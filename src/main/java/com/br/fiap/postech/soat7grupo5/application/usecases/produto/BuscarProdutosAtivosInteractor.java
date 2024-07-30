package com.br.fiap.postech.soat7grupo5.application.usecases.produto;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.ProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;

public class BuscarProdutosAtivosInteractor {

private ProdutoGateway produtoGateway;
	
	public BuscarProdutosAtivosInteractor(ProdutoGateway produtoGateway) {
		this.produtoGateway = produtoGateway;
	}
	
	public List<Produto> buscarProdutosAtivos() {
		return produtoGateway.buscarProdutosAtivos();
	}
}
