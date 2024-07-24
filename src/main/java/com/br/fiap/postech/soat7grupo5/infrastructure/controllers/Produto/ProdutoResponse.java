package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.Produto;

public record ProdutoResponse(int idProduto, String nome, String descricao, Double preco, int duracaoPreparo, int idTipo, int flAtivo) {

}