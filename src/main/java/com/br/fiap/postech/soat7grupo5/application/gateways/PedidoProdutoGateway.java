package com.br.fiap.postech.soat7grupo5.application.gateways;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;

public interface PedidoProdutoGateway {

	public List<PedidoProduto> buscarPedidoProdutos();
	public void salvarPedidoProduto(List<PedidoProduto> pedidoProdutoDTOs);
	public List<PedidoProduto> buscarPedidoProdutosPorIdPedido(int idPedido);
	
}
