package com.br.fiap.postech.soat7grupo5.application.usecases.pedido;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;

public class EditarPedidoInteractor {

	private PedidoGateway pedidoGateway;
	
	public EditarPedidoInteractor(PedidoGateway pedidoGateway) {
		this.pedidoGateway = pedidoGateway;
	}
	
	public Pedido editarPedido(int idPedido, int idStatusPedido) {
		return pedidoGateway.editarPedido(idPedido, idStatusPedido);
	}
}
