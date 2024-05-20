package com.br.fiap.postech.soat7grupo5.infra.adapters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fiap.postech.soat7grupo5.infra.adapters.entities.ProdutoEntity;

@Repository
public interface ProdutoRepositoryJpa extends JpaRepository<ProdutoEntity, Integer> {

	List<ProdutoEntity> findByIdTipo(int idTipo);
	List<ProdutoEntity> findByFlAtivoOrderByIdTipoAsc(int flAtivo);

}