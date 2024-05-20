package com.br.fiap.postech.soat7grupo5.infra.adapters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fiap.postech.soat7grupo5.infra.adapters.entities.PedidoProdutoEntity;

@Repository
public interface PedidoProdutoRepositoryJpa extends JpaRepository<PedidoProdutoEntity, Integer> {

	List<PedidoProdutoEntity> findByIdPedido(int idPedido);

}
