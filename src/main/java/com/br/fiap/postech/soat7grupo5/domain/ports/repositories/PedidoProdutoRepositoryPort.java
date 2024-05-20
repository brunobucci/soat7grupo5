package com.br.fiap.postech.soat7grupo5.domain.ports.repositories;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.PedidoProduto;

public interface PedidoProdutoRepositoryPort {
	List<PedidoProduto> buscarTodos();
	List<PedidoProduto> buscarPedidoProdutosPorIdPedido(int idPedido);
	void salvarPedidoProdutos(List<PedidoProduto> pedidoProdutos);
}
