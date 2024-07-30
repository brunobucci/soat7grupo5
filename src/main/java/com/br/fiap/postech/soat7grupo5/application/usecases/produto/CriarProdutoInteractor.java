package com.br.fiap.postech.soat7grupo5.application.usecases.produto;

import com.br.fiap.postech.soat7grupo5.application.gateways.ProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;

public class CriarProdutoInteractor {

	private ProdutoGateway produtoGateway;
	
	public CriarProdutoInteractor(ProdutoGateway produtoGateway) {
		this.produtoGateway = produtoGateway;
	}
	
	public Produto criarProduto(Produto produto) {
		return produtoGateway.criarProduto(produto);
	}
}
