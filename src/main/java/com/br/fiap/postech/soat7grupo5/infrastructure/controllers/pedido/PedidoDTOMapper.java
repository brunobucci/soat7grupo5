package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;

public class PedidoDTOMapper {

	PedidoResponse toResponse(Pedido pedido) {
		return new PedidoResponse(pedido.getIdPedido(), pedido.getPreco(), pedido.getIdStatusPagamento(), pedido.getIdCliente(), pedido.getIdPedido(), pedido.getDuracaoTotalPreparo(), pedido.getDataCriacao(), pedido.getIdStatusPagamento());
	}
	
	Pedido toPedido(PedidoRequest request) {
		return new Pedido(request.idPedido(), request.preco(), request.idStatusPedido(), request.idCliente(), request.idStatusPagamento(), request.duracaoTotalPreparo(), request.dataCriacao(), request.idStatusPagamento());
	}

	public List<PedidoResponse> toResponseList(List<Pedido> pedidos) {
		return pedidos.stream().map(Pedido::toPedidoResponse).collect(Collectors.toList());
	}
}
