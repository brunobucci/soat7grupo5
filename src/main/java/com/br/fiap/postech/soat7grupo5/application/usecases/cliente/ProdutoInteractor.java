package com.br.fiap.postech.soat7grupo5.application.usecases.cliente;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.ProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;

public class ProdutoInteractor {
	
	private ProdutoGateway produtoGateway;
	
	public ProdutoInteractor(ProdutoGateway produtoGateway) {
		this.produtoGateway = produtoGateway;
	}
	
	public Produto criarProduto(Produto produto) {
		return produtoGateway.criarProduto(produto);
	}
	
	public Produto editarProduto(Produto produto) {
		return produtoGateway.editarProduto(produto);
	}
	
	public void deletarProduto(int idProduto) {
		produtoGateway.deletarProduto(idProduto);
	}
	
	public List<Produto> buscarProdutosPorTipo(int tipo) {
		return produtoGateway.buscarProdutosPorTipo(tipo);
	}

	
	public List<Produto> buscarProdutosAtivos() {
		return produtoGateway.buscarProdutosAtivos();
	}
	
}
