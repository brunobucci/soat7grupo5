package com.br.fiap.postech.soat7grupo5.application.usecases.pedidoproduto;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;

public class BuscarPedidoProdutoInteractor {

	private PedidoProdutoGateway pedidoProdutoGateway;
	
	public BuscarPedidoProdutoInteractor(PedidoProdutoGateway pedidoProdutoGateway) {
		this.pedidoProdutoGateway = pedidoProdutoGateway;
	}
	
	public List<PedidoProduto> buscarPedidoProdutos(){
		return pedidoProdutoGateway.buscarPedidoProdutos();
	}
}
