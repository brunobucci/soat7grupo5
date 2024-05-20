package com.br.fiap.postech.soat7grupo5.domain.ports.interfaces;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.dtos.PedidoProdutoDTO;

public interface PedidoProdutoServicePort {
	List<PedidoProdutoDTO> buscarPedidoProdutos();
	List<PedidoProdutoDTO> buscarPedidoProdutosPorIdPedido(int idPedido);
	void salvarPedidoProduto(int idPedido, List<PedidoProdutoDTO> pedidoProdutoDTOs);
}
