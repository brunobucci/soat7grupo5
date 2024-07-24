package com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ProdutoEntity;

public class ProdutoEntityMapper {

	public ProdutoEntity toEntity(Produto produtoDomainObj) {
		return new ProdutoEntity(produtoDomainObj.idProduto(), produtoDomainObj.nome(), produtoDomainObj.descricao(), produtoDomainObj.preco(), produtoDomainObj.duracaoPreparo(), produtoDomainObj.idTipo(), produtoDomainObj.flAtivo());
	}
	
	public Produto toDomainObj(ProdutoEntity produtoEntity) {
		return new Produto(produtoEntity.getIdProduto(), produtoEntity.getNome(), produtoEntity.getDescricao(), produtoEntity.getPreco(), produtoEntity.getDuracaoPreparo(), produtoEntity.getIdTipo(), produtoEntity.getFlAtivo());
	}

	public List<Produto> toDomainObjList(List<ProdutoEntity> savedObjList) {
		return savedObjList.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
	}
}
