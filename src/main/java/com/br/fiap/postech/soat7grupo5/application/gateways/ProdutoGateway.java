package com.br.fiap.postech.soat7grupo5.application.gateways;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;

public interface ProdutoGateway {

	Produto criarProduto(Produto produto);
	Produto editarProduto(Produto produto);
	void deletarProduto(int idProduto);
	List<Produto> buscarProdutosPorTipo(int tipo);	
	List<Produto> buscarProdutosAtivos();
	
}
