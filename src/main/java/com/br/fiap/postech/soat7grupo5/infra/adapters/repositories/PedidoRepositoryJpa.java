package com.br.fiap.postech.soat7grupo5.infra.adapters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fiap.postech.soat7grupo5.infra.adapters.entities.PedidoEntity;

@Repository
public interface PedidoRepositoryJpa extends JpaRepository<PedidoEntity, Integer> {
	List<PedidoEntity> findByIdStatus(int idStatus);
}