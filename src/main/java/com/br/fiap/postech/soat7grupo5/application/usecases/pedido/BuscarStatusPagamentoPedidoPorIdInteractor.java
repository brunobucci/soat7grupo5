package com.br.fiap.postech.soat7grupo5.application.usecases.pedido;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;

public class BuscarStatusPagamentoPedidoPorIdInteractor {

	private PedidoGateway pedidoGateway;
	
	public BuscarStatusPagamentoPedidoPorIdInteractor(PedidoGateway pedidoGateway) {
		this.pedidoGateway = pedidoGateway;
	}

	public boolean buscarStatusPagamentoPedidoPorId(int idPedido) {
		return pedidoGateway.buscarStatusPagamentoPedidoPorId(idPedido);
	}

}
