package com.br.fiap.postech.soat7grupo5.application.usecases.produto;

import com.br.fiap.postech.soat7grupo5.application.gateways.ProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;

public class EditarProdutoInteractor {

	private ProdutoGateway produtoGateway;
	
	public EditarProdutoInteractor(ProdutoGateway produtoGateway) {
		this.produtoGateway = produtoGateway;
	}

	public Produto editarProduto(Produto produto) {
		return produtoGateway.editarProduto(produto);
	}
}
