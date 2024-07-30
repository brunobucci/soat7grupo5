package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido;

import java.util.Date;

public record PedidoResponse(int idPedido, Double preco, int idStatusPedido, int idCliente, int idTipoPagamento, int duracaoTotalPreparo, Date dataCriacao, int idStatusPagamento) {
	public PedidoResponse toPedidoResponse() {
		return new PedidoResponse(this.idPedido, this.preco, this.idStatusPedido, this.idCliente, this.idTipoPagamento, this.duracaoTotalPreparo, this.dataCriacao, this.idStatusPagamento);
	}
}
