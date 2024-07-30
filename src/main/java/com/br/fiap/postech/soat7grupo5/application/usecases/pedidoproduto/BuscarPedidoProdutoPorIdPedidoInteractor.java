package com.br.fiap.postech.soat7grupo5.application.usecases.pedidoproduto;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;

public class BuscarPedidoProdutoPorIdPedidoInteractor {

	private PedidoProdutoGateway pedidoProdutoGateway;
	
	public BuscarPedidoProdutoPorIdPedidoInteractor(PedidoProdutoGateway pedidoProdutoGateway) {
		this.pedidoProdutoGateway = pedidoProdutoGateway;
	}
	
	public List<PedidoProduto> buscarPedidoProdutosPorIdPedido(int idPedido){
		return pedidoProdutoGateway.buscarPedidoProdutosPorIdPedido(idPedido);
	}
}
