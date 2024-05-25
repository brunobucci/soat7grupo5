package com.br.fiap.postech.soat7grupo5.adapters.controllers;

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

import com.br.fiap.postech.soat7grupo5.domain.dtos.PedidoCompletoDTO;
import com.br.fiap.postech.soat7grupo5.domain.dtos.PedidoDTO;
import com.br.fiap.postech.soat7grupo5.domain.dtos.PedidoProdutoDTO;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.PedidoProdutoServicePort;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.PedidoServicePort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Pedidos", description = "Recursos relacionados aos pedidos.")
@RequestMapping(path="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

	private final PedidoServicePort pedidoServicePort;
	private final PedidoProdutoServicePort pedidoProdutoServicePort;

	public PedidoController(PedidoServicePort pedidoServicePort, PedidoProdutoServicePort pedidoProdutoServicePort) {
		this.pedidoServicePort = pedidoServicePort;
		this.pedidoProdutoServicePort = pedidoProdutoServicePort;
	}

	@GetMapping
	@Operation(summary = "Retorna lista com todos os pedidos cadastrados.")
	List<PedidoCompletoDTO> buscarPedidos() {
		List<PedidoCompletoDTO> listaPedidoCompletosDTO = new ArrayList<PedidoCompletoDTO>(); 
		List<PedidoDTO> listaPedidosDTO = pedidoServicePort.buscarPedidos();
		for(PedidoDTO pedidoDTO : listaPedidosDTO) {
			PedidoCompletoDTO pedidoCompletoDTO = new PedidoCompletoDTO();
			pedidoCompletoDTO.setPedidoDTO(pedidoDTO);
			pedidoCompletoDTO.setPedidoProdutoDTOs(pedidoProdutoServicePort.buscarPedidoProdutosPorIdPedido(pedidoDTO.getIdPedido()));
			listaPedidoCompletosDTO.add(pedidoCompletoDTO);
		}
		return listaPedidoCompletosDTO;
	}

	@PostMapping
	@Operation(summary = "Realiza o cadastro do pedido.")
	void salvarPedido(@RequestBody PedidoCompletoDTO pedidoCompletoDTO) {
		Double precoTotal = pedidoCompletoDTO.getPedidoProdutoDTOs().stream().collect(Collectors.summingDouble(PedidoProdutoDTO::getPrecoProduto));
		int duracaoTotal = pedidoCompletoDTO.getPedidoProdutoDTOs().stream().collect(Collectors.summingInt(PedidoProdutoDTO::getDuracaoPreparo));
		pedidoCompletoDTO.getPedidoDTO().setPreco(precoTotal);
		pedidoCompletoDTO.getPedidoDTO().setDuracaoTotalPreparo(duracaoTotal);
		PedidoDTO pedidoDTO = pedidoServicePort.salvarPedido(pedidoCompletoDTO.getPedidoDTO());
		pedidoProdutoServicePort.salvarPedidoProduto(pedidoDTO.getIdPedido(), pedidoCompletoDTO.getPedidoProdutoDTOs());
	}
	
	@PutMapping(path="{idPedido}/status/{idStatus}")
	@Operation(summary = "Realiza a edição do pedido.")
	void editarPedido(@Parameter(description = "ID do pedido.", example = "1") @PathVariable int idPedido, @Parameter(description = "ID do status do pedido (1: Pendente Pagamento, 2: Em preparação, 3: Pronto, 4: Finalizado).", example = "1") @PathVariable int idStatus) {
		PedidoDTO pedidoDTO = new PedidoDTO(idPedido, idStatus);
		pedidoServicePort.salvarPedido(pedidoDTO);
	}

	@GetMapping(path="/status/{idStatus}")
	@Operation(summary = "Retorna lista com todos os pedidos cadastrados por status.")
	List<PedidoCompletoDTO> buscarPedidosPorStatus(@Parameter(description = "ID do status do pedido (1: Pendente Pagamento, 2: Em preparação, 3: Pronto, 4: Finalizado).", example = "1") @PathVariable int idStatus) {
		List<PedidoCompletoDTO> listaPedidoCompletosDTO = new ArrayList<PedidoCompletoDTO>(); 
		List<PedidoDTO> listaPedidosDTO = pedidoServicePort.buscarPedidosPorStatus(idStatus);
		for(PedidoDTO pedidoDTO : listaPedidosDTO) {
			PedidoCompletoDTO pedidoCompletoDTO = new PedidoCompletoDTO();
			pedidoCompletoDTO.setPedidoDTO(pedidoDTO);
			pedidoCompletoDTO.setPedidoProdutoDTOs(pedidoProdutoServicePort.buscarPedidoProdutosPorIdPedido(pedidoDTO.getIdPedido()));
			listaPedidoCompletosDTO.add(pedidoCompletoDTO);
		}
		return listaPedidoCompletosDTO;
	}
}
