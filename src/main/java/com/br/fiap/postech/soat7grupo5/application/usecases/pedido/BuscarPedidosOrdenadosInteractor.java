package com.br.fiap.postech.soat7grupo5.application.usecases.pedido;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;

public class BuscarPedidosOrdenadosInteractor {

	private PedidoGateway pedidoGateway;
	
	public BuscarPedidosOrdenadosInteractor(PedidoGateway pedidoGateway) {
		this.pedidoGateway = pedidoGateway;
	}

	public List<Pedido> buscarPedidosOrdenados() {
		return pedidoGateway.buscarPedidosOrdenados();
	}
}
