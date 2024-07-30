package com.br.fiap.postech.soat7grupo5.application.usecases.produto;

import com.br.fiap.postech.soat7grupo5.application.gateways.ProdutoGateway;

public class DeletarProdutoInteractor {
	
	private ProdutoGateway produtoGateway;
	
	public DeletarProdutoInteractor(ProdutoGateway produtoGateway) {
		this.produtoGateway = produtoGateway;
	}
	
	public void deletarProduto(int idProduto) {
		produtoGateway.deletarProduto(idProduto);
	}
}
