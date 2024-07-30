package com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoEntity;

public class PedidoEntityMapper {

	public PedidoEntity toEntity(Pedido pedidoDomainObj) {
		return new PedidoEntity(pedidoDomainObj.getIdPedido(), pedidoDomainObj.getPreco(), pedidoDomainObj.getIdStatusPagamento(), pedidoDomainObj.getIdCliente(), pedidoDomainObj.getIdTipoPagamento(), pedidoDomainObj.getDuracaoTotalPreparo(), pedidoDomainObj.getDataCriacao(), pedidoDomainObj.getIdStatusPagamento());
	}
	
	public Pedido toDomainObj(PedidoEntity pedidoEntity) {
		return new Pedido(pedidoEntity.getIdPedido(), pedidoEntity.getPreco(), pedidoEntity.getIdStatusPagamento(), pedidoEntity.getIdCliente(), pedidoEntity.getIdTipoPagamento(), pedidoEntity.getDuracaoTotalPreparo(), pedidoEntity.getDataCriacao(), pedidoEntity.getIdStatusPagamento());
	}

	public List<Pedido> toDomainObjList(List<PedidoEntity> savedObjList) {
		return savedObjList.stream().map(PedidoEntity::toPedido).collect(Collectors.toList());
	}
}
