package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.produto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;

public class ProdutoDTOMapper {

	ProdutoResponse toResponse(Produto produto) {
		return new ProdutoResponse(produto.idProduto(), produto.nome(), produto.descricao(), produto.preco(), produto.duracaoPreparo(), produto.idTipo(), produto.flAtivo());
	}
	
	Produto toProduto(ProdutoRequest request) {
		return new Produto(request.idProduto(), request.nome(), request.descricao(), request.preco(), request.duracaoPreparo(), request.idTipo(), request.flAtivo());
	}

	public List<ProdutoResponse> toResponseList(List<Produto> produtos) {
		return produtos.stream().map(Produto::toProdutoResponse).collect(Collectors.toList());
	}
	
}
