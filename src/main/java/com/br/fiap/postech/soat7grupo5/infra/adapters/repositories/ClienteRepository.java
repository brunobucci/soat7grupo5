package com.br.fiap.postech.soat7grupo5.infra.adapters.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.br.fiap.postech.soat7grupo5.domain.Cliente;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.ClienteRepositoryPort;
import com.br.fiap.postech.soat7grupo5.infra.adapters.entities.ClienteEntity;

@Component
public class ClienteRepository implements ClienteRepositoryPort {

	private final ClienteRepositoryJpa clienteRepositoryJpa;

	public ClienteRepository(ClienteRepositoryJpa clienteRepositoryJpa) {
		this.clienteRepositoryJpa = clienteRepositoryJpa;
	}

	@Override
	public void salvar(Cliente cliente) {
		ClienteEntity clienteEntity;
		if (cliente.getIdCliente() == 0) {
			clienteEntity = new ClienteEntity(cliente);
		}
		else {
			clienteEntity = this.clienteRepositoryJpa.findById(cliente.getIdCliente()).get();
			clienteEntity.atualizar(cliente);
		}
		this.clienteRepositoryJpa.save(clienteEntity);
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<ClienteEntity> clienteEntities = this.clienteRepositoryJpa.findAll();
		return clienteEntities.stream().map(ClienteEntity::toCliente).collect(Collectors.toList());
	}

	@Override
	public Cliente buscarPorId(int idCliente) {
		Optional<ClienteEntity> clienteEntity = this.clienteRepositoryJpa.findById(idCliente);
		if (clienteEntity.isPresent())
			return clienteEntity.get().toCliente();

		throw new RuntimeException("Cliente não existe");
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		Optional<ClienteEntity> clienteEntity = this.clienteRepositoryJpa.findByCpf(cpf);
		if (clienteEntity.isPresent())
			return clienteEntity.get().toCliente();

		throw new RuntimeException("Cliente não existe");
	}
}