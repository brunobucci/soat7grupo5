package com.br.fiap.postech.soat7grupo5.application.usecases.pedidoproduto;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;

public class SalvarPedidoProdutoInteractor {

	private PedidoProdutoGateway pedidoProdutoGateway;
	
	public SalvarPedidoProdutoInteractor(PedidoProdutoGateway pedidoProdutoGateway) {
		this.pedidoProdutoGateway = pedidoProdutoGateway;
	}
	
	public void salvarPedidoProduto(int idPedido, List<PedidoProduto> pedidoProdutos) {
		for(PedidoProduto pedidoProduto : pedidoProdutos) {
			pedidoProduto.setIdPedido(idPedido);
		}
		pedidoProdutoGateway.salvarPedidoProduto(pedidoProdutos);
	}
}
