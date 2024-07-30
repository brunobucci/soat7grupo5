package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5.application.usecases.PedidoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.PedidoProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;
import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Pedidos", description = "Recursos relacionados aos pedidos.")
@RequestMapping(path="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

	private final PedidoInteractor pedidoInteractor; 
	private final PedidoDTOMapper pedidoDTOMapper;
	private final PedidoProdutoInteractor pedidoProdutoInteractor;
	
    public PedidoController(PedidoInteractor pedidoInteractor, PedidoDTOMapper pedidoDTOMapper, PedidoProdutoInteractor pedidoProdutoInteractor) {
        this.pedidoInteractor = pedidoInteractor;
        this.pedidoDTOMapper = pedidoDTOMapper;
		this.pedidoProdutoInteractor = pedidoProdutoInteractor;
    }

    @PostMapping(path="/checkout")
    @Operation(summary = "Realiza o cadastro do pedido.")
    String criarPedido(@RequestBody PedidoCompletoRequest pedidoCompletoRequest) {
    	
    	Double precoTotal = pedidoCompletoRequest.getPedidoProdutos().stream().collect(Collectors.summingDouble(PedidoProduto::getPrecoProduto));
		int duracaoTotal = pedidoCompletoRequest.getPedidoProdutos().stream().collect(Collectors.summingInt(PedidoProduto::getDuracaoPreparo));
		pedidoCompletoRequest.getPedido().setPreco(precoTotal);
		pedidoCompletoRequest.getPedido().setDuracaoTotalPreparo(duracaoTotal);
		
		Pedido pedido = pedidoInteractor.criarPedido(pedidoCompletoRequest.getPedido());
		
		pedidoProdutoInteractor.salvarPedidoProduto(pedido.getIdPedido(), pedidoCompletoRequest.getPedidoProdutos());
    	
    	return "idPedido: "+pedido.getIdPedido();
    }
    
    @PutMapping(path="{idPedido}/status/{idStatus}")
    @Operation(summary = "Realiza a edição do pedido.")
    PedidoResponse editarPedido(@Parameter(description = "ID do pedido.", example = "1") @PathVariable int idPedido, @Parameter(description = "ID do status do pedido (1: Recebido, 2: Em preparação, 3: Pronto, 4: Finalizado).", example = "1") @PathVariable int idStatus) {
    	Pedido pedido = pedidoInteractor.editarPedido(idPedido, idStatus);
    	return pedidoDTOMapper.toResponse(pedido);
    }
    
    @GetMapping
    @Operation(summary = "Retorna lista com todos os pedidos cadastrados.")
    List<PedidoResponse> buscarPedidos() {
    	List<Pedido> pedidos = pedidoInteractor.buscarPedidos();
    	return pedidoDTOMapper.toResponseList(pedidos);
    }
    
    @GetMapping(path="/busca-ordenada")
    @Operation(summary = "Retorna lista com pedidos ordenados.")
    List<PedidoResponse> buscarPedidosOrdenados() {
    	List<Pedido> pedidos = pedidoInteractor.buscarPedidosOrdenados();
    	return pedidoDTOMapper.toResponseList(pedidos);
    }
    
    @GetMapping(path="/status-pagamento/{idPedido}")
    @Operation(summary = "Buscar status pagamento por id do pedido.")
    String buscarStatusPagamentoPedidoPorId(@Parameter(description = "ID do pedido", example = "1") @PathVariable int idPedido) {
    	boolean pagamentAprovado = pedidoInteractor.buscarStatusPagamentoPedidoPorId(idPedido);
    	return "pagamentoAprovado: " + pagamentAprovado;
    }    
    
    @GetMapping(path="/{idStatus}")
    @Operation(summary = "Busca pedidos por status.")
    List<PedidoResponse> buscarPedidosPorStatus(@Parameter(description = "ID do status", example = "1") @PathVariable int idStatus) {
    	List<Pedido> pedidos = pedidoInteractor.buscarPedidosPorStatus(idStatus);
    	return pedidoDTOMapper.toResponseList(pedidos);
    }
}
