package com.br.fiap.postech.soat7grupo5.infrastructure.gateways;

import java.util.List;
import java.util.Optional;

import com.br.fiap.postech.soat7grupo5.application.gateways.ClienteGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.ClienteEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ClienteEntity;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ClienteRepository;

public class ClienteRepositoryGateway implements ClienteGateway{

	private final ClienteRepository clienteRepository;
	private final ClienteEntityMapper clienteEntityMapper;  
	
	public ClienteRepositoryGateway(ClienteRepository clienteRepository, ClienteEntityMapper clienteEntityMapper) {
		this.clienteRepository = clienteRepository;
		this.clienteEntityMapper = clienteEntityMapper;
	}

	@Override
	public Cliente criarCliente(Cliente clienteDomainObj) {
		ClienteEntity clienteEntity = clienteEntityMapper.toEntity(clienteDomainObj); 
		ClienteEntity savedObj = clienteRepository.save(clienteEntity);
		return clienteEntityMapper.toDomainObj(savedObj); 
	}

	@Override
	public Cliente buscarClientePorId(int id) {
		Optional<ClienteEntity> savedObj = clienteRepository.findById(id);
		return clienteEntityMapper.toDomainObj(savedObj.get());
	}
	@Override
	public Cliente buscarClientePorCpf(String cpf) {
		Optional<ClienteEntity> savedObj = clienteRepository.findByCpf(cpf);
		return clienteEntityMapper.toDomainObj(savedObj.get());
	}
	
	@Override
	public List<Cliente> buscarClientes() {
		List<ClienteEntity> savedObjList = (List<ClienteEntity>) clienteRepository.findAll();
		return clienteEntityMapper.toDomainObjList(savedObjList); 
	}
}
