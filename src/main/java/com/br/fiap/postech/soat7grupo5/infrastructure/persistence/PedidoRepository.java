package com.br.fiap.postech.soat7grupo5.infrastructure.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<PedidoEntity, Integer> {
	List<PedidoEntity> findByIdStatusPedido(int idStatus);
	List<PedidoEntity> findAllByIdStatusPedidoNotOrderByIdStatusPedidoDescDataCriacaoDesc(int idStatusPedido);
}
