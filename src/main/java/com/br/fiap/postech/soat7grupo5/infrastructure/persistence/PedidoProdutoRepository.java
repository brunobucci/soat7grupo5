package com.br.fiap.postech.soat7grupo5.infrastructure.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PedidoProdutoRepository extends CrudRepository<PedidoProdutoEntity, Integer>{

	List<PedidoProdutoEntity> findByIdPedido(int idPedido);

}
