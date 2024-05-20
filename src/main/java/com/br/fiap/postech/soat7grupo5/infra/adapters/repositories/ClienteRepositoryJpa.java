package com.br.fiap.postech.soat7grupo5.infra.adapters.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fiap.postech.soat7grupo5.infra.adapters.entities.ClienteEntity;

@Repository
public interface ClienteRepositoryJpa extends JpaRepository<ClienteEntity, Integer> {

	Optional<ClienteEntity> findById(int idCliente);
	Optional<ClienteEntity> findByCpf(String cpf);

}