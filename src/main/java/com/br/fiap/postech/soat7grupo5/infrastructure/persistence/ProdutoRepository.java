package com.br.fiap.postech.soat7grupo5.infrastructure.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Integer>{

	List<ProdutoEntity> findByIdTipo(int idTipo);
	List<ProdutoEntity> findByFlAtivoOrderByIdTipoAsc(int flAtivo);
}
