package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido;

import java.util.ArrayList;
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

import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.AtualizarStatusPagamentoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarPedidoPorIdInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarPedidosInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarPedidosOrdenadosInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarPedidosPorStatusInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarStatusPagamentoPedidoPorIdInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.CriarPedidoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.EditarPedidoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedidoproduto.BuscarPedidoProdutoPorIdPedidoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedidoproduto.SalvarPedidoProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;
import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Pedidos", description = "Recursos relacionados aos pedidos.")
@RequestMapping(path="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

	private final CriarPedidoInteractor criarPedidoInteractor;
	private final EditarPedidoInteractor editarPedidoInteractor;
	private final BuscarPedidosPorStatusInteractor buscarPedidosPorStatusInteractor;
	private final BuscarPedidosInteractor buscarPedidosInteractor;
	private final BuscarStatusPagamentoPedidoPorIdInteractor buscarStatusPagamentoPedidoPorIdInteractor;
	private final BuscarPedidosOrdenadosInteractor buscarPedidosOrdenadosInteractor;
	private final BuscarPedidoPorIdInteractor buscarPedidoPorIdInteractor;
	private final AtualizarStatusPagamentoInteractor atualizarStatusPagamentoInteractor;
	private final BuscarPedidoProdutoPorIdPedidoInteractor buscarPedidoProdutoPorIdPedidoInteractor;

	private final PedidoDTOMapper pedidoDTOMapper;
	private final SalvarPedidoProdutoInteractor salvarPedidoProdutoInteractor;

	public PedidoController(CriarPedidoInteractor criarPedidoInteractor, EditarPedidoInteractor editarPedidoInteractor, BuscarPedidosPorStatusInteractor buscarPedidosPorStatusInteractor, BuscarPedidosInteractor buscarPedidosInteractor, 
			BuscarStatusPagamentoPedidoPorIdInteractor buscarStatusPagamentoPedidoPorIdInteractor, BuscarPedidosOrdenadosInteractor buscarPedidosOrdenadosInteractor, BuscarPedidoPorIdInteractor buscarPedidoPorIdInteractor,
			AtualizarStatusPagamentoInteractor atualizarStatusPagamentoInteractor, PedidoDTOMapper pedidoDTOMapper, SalvarPedidoProdutoInteractor salvarPedidoProdutoInteractor, BuscarPedidoProdutoPorIdPedidoInteractor buscarPedidoProdutoPorIdPedidoInteractor) {
		this.criarPedidoInteractor = criarPedidoInteractor;
		this.editarPedidoInteractor = editarPedidoInteractor;
		this.buscarPedidosPorStatusInteractor = buscarPedidosPorStatusInteractor;
		this.buscarPedidosInteractor = buscarPedidosInteractor;
		this.buscarStatusPagamentoPedidoPorIdInteractor = buscarStatusPagamentoPedidoPorIdInteractor;
		this.buscarPedidosOrdenadosInteractor = buscarPedidosOrdenadosInteractor;
		this.buscarPedidoPorIdInteractor = buscarPedidoPorIdInteractor;
		this.atualizarStatusPagamentoInteractor = atualizarStatusPagamentoInteractor;
		this.pedidoDTOMapper = pedidoDTOMapper;
		this.salvarPedidoProdutoInteractor = salvarPedidoProdutoInteractor;
		this.buscarPedidoProdutoPorIdPedidoInteractor = buscarPedidoProdutoPorIdPedidoInteractor;
	}

	@PostMapping(path="/checkout")
	@Operation(summary = "Realiza o cadastro do pedido.")
	String criarPedido(@RequestBody PedidoCompletoRequest pedidoCompletoRequest) {

		Double precoTotal = pedidoCompletoRequest.getPedidoProdutos().stream().collect(Collectors.summingDouble(PedidoProduto::getPrecoProduto));
		int duracaoTotal = pedidoCompletoRequest.getPedidoProdutos().stream().collect(Collectors.summingInt(PedidoProduto::getDuracaoPreparo));
		pedidoCompletoRequest.getPedido().setPreco(precoTotal);
		pedidoCompletoRequest.getPedido().setDuracaoTotalPreparo(duracaoTotal);

		Pedido pedido = criarPedidoInteractor.criarPedido(pedidoCompletoRequest.getPedido());

		salvarPedidoProdutoInteractor.salvarPedidoProduto(pedido.getIdPedido(), pedidoCompletoRequest.getPedidoProdutos());

		return "{ \"idPedido\" : "+pedido.getIdPedido()+ " }";
	}

	@PutMapping(path="{idPedido}/status/{idStatus}")
	@Operation(summary = "Realiza a edição do pedido.")
	PedidoResponse editarPedido(@Parameter(description = "ID do pedido.", example = "1") @PathVariable int idPedido, @Parameter(description = "ID do status do pedido (1: Recebido, 2: Em preparação, 3: Pronto, 4: Finalizado).", example = "1") @PathVariable int idStatus) {
		Pedido pedido = editarPedidoInteractor.editarPedido(idPedido, idStatus);
		return pedidoDTOMapper.toResponse(pedido);
	}

	@GetMapping
	@Operation(summary = "Retorna lista com todos os pedidos cadastrados.")
	List<PedidoCompletoResponse> buscarPedidos() {
		List<PedidoCompletoResponse> pedidosCompletosResponse = new ArrayList<PedidoCompletoResponse>(); 
		List<Pedido> pedidos = buscarPedidosInteractor.buscarPedidos();
		for(Pedido pedido : pedidos){
			PedidoCompletoResponse pedidoCompletoResponse = new PedidoCompletoResponse();
			pedidoCompletoResponse.setPedido(pedido);
			List<PedidoProduto> pedidoProdutosPedido = buscarPedidoProdutoPorIdPedidoInteractor.buscarPedidoProdutosPorIdPedido(pedido.getIdPedido());
			pedidoCompletoResponse.setPedidoProdutos(pedidoProdutosPedido);
			pedidosCompletosResponse.add(pedidoCompletoResponse);
		}	
		return pedidosCompletosResponse;
	}

	@GetMapping(path="/busca-ordenada")
	@Operation(summary = "Retorna lista com pedidos ordenados.")
	List<PedidoCompletoResponse> buscarPedidosOrdenados() {
		List<PedidoCompletoResponse> pedidosCompletosResponse = new ArrayList<PedidoCompletoResponse>();
		List<Pedido> pedidos = buscarPedidosOrdenadosInteractor.buscarPedidosOrdenados();
		for(Pedido pedido : pedidos){
			PedidoCompletoResponse pedidoCompletoResponse = new PedidoCompletoResponse();
			pedidoCompletoResponse.setPedido(pedido);
			pedidoCompletoResponse.setPedidoProdutos(buscarPedidoProdutoPorIdPedidoInteractor.buscarPedidoProdutosPorIdPedido(pedido.getIdPedido()));
			pedidosCompletosResponse.add(pedidoCompletoResponse);
		}	
		return pedidosCompletosResponse;
	}

	@GetMapping(path="/status-pagamento/{idPedido}")
	@Operation(summary = "Buscar status pagamento por id do pedido.")
	String buscarStatusPagamentoPedidoPorId(@Parameter(description = "ID do pedido", example = "1") @PathVariable int idPedido) {
		boolean pagamentAprovado = buscarStatusPagamentoPedidoPorIdInteractor.buscarStatusPagamentoPedidoPorId(idPedido);
		return "{ \"pagamentoAprovado\" : " + pagamentAprovado + " }";
	}    

	@GetMapping(path="/{idStatus}")
	@Operation(summary = "Busca pedidos por status.")
	List<PedidoResponse> buscarPedidosPorStatus(@Parameter(description = "ID do status", example = "1") @PathVariable int idStatus) {
		List<Pedido> pedidos = buscarPedidosPorStatusInteractor.buscarPedidosPorStatus(idStatus);
		return pedidoDTOMapper.toResponseList(pedidos);
	}
}
