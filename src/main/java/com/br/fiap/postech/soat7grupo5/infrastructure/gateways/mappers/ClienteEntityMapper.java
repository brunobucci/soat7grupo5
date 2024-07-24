package com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ClienteEntity;

public class ClienteEntityMapper {

	public ClienteEntity toEntity(Cliente clienteDomainObj) {
		return new ClienteEntity(clienteDomainObj.idCliente(), clienteDomainObj.nome(), clienteDomainObj.cpf(), clienteDomainObj.email(), clienteDomainObj.idCampanha());
	}
	
	public Cliente toDomainObj(ClienteEntity clienteEntity) {
		return new Cliente(clienteEntity.getIdCliente(), clienteEntity.getNome(), clienteEntity.getCpf(), clienteEntity.getEmail(), clienteEntity.getIdCampanha());
	}

	public List<Cliente> toDomainObjList(List<ClienteEntity> savedObjList) {
		return savedObjList.stream().map(ClienteEntity::toCliente).collect(Collectors.toList());
	}
	
}