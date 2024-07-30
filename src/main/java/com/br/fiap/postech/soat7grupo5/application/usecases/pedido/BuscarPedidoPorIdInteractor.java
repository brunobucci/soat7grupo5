package com.br.fiap.postech.soat7grupo5.application.usecases.pedido;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;

public class BuscarPedidoPorIdInteractor {

	private PedidoGateway pedidoGateway;
	
	public BuscarPedidoPorIdInteractor(PedidoGateway pedidoGateway) {
		this.pedidoGateway = pedidoGateway;
	}

	public Pedido buscarPedidoPorId(int idPedido) {
		return pedidoGateway.buscarPedidoPorId(idPedido);
	}
}
