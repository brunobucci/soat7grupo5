package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;
import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;

public class PedidoCompletoResponse {
	
	private Pedido pedido;
	private List<PedidoProduto> pedidoProdutos;
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public List<PedidoProduto> getPedidoProdutos() {
		return pedidoProdutos;
	}
	public void setPedidoProdutos(List<PedidoProduto> pedidoProdutos) {
		this.pedidoProdutos = pedidoProdutos;
	}
}
