package com.br.fiap.postech.soat7grupo5.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer>{

	Optional<ClienteEntity> findByCpf(String cpf);

}
