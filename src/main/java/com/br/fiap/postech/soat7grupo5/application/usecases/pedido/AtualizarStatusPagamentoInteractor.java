package com.br.fiap.postech.soat7grupo5.application.usecases.pedido;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;

public class AtualizarStatusPagamentoInteractor {

private PedidoGateway pedidoGateway;
	
	public AtualizarStatusPagamentoInteractor(PedidoGateway pedidoGateway) {
		this.pedidoGateway = pedidoGateway;
	}
	public Pedido atualizarStatusPagamento(int idPedido, int idStatusPagamento) {
		return pedidoGateway.atualizarStatusPagamento(idPedido, idStatusPagamento);
	}
}
