package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.produto;

public record ProdutoResponse(int idProduto, String nome, String descricao, Double preco, int duracaoPreparo, int idTipo, int flAtivo) {

}