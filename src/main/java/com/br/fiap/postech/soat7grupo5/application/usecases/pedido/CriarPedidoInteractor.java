package com.br.fiap.postech.soat7grupo5.application.usecases.pedido;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;

public class CriarPedidoInteractor {

	private PedidoGateway pedidoGateway;
	
	public CriarPedidoInteractor(PedidoGateway pedidoGateway) {
		this.pedidoGateway = pedidoGateway;
	}
	
	public Pedido criarPedido(Pedido pedido) {
		return pedidoGateway.criarPedido(pedido);
	}
	
}
