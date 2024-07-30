package com.br.fiap.postech.soat7grupo5.domain.entity;

import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.produto.ProdutoResponse;

public record Produto(int idProduto, String nome, String descricao, Double preco, int duracaoPreparo, int idTipo, int flAtivo) {

	public ProdutoResponse toProdutoResponse() {
		return new ProdutoResponse(this.idProduto, this.nome, this.descricao, this.preco, this.duracaoPreparo, this.idTipo, this.flAtivo);
	}
}
