package com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoProdutoEntity;

public class PedidoProdutoEntityMapper {

	public List<PedidoProduto> toDomainObjList(List<PedidoProdutoEntity> savedObjList) {
		return savedObjList.stream().map(PedidoProdutoEntity::toPedidoProduto).collect(Collectors.toList());
	}

}
