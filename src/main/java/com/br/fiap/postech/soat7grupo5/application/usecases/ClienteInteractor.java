package com.br.fiap.postech.soat7grupo5.application.usecases;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.ClienteGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

public class ClienteInteractor {

	private ClienteGateway clienteGateway;
	
	public ClienteInteractor(ClienteGateway clienteGateway) {
		this.clienteGateway = clienteGateway;
	}
	
	public Cliente criarCliente(Cliente cliente) {
		return clienteGateway.criarCliente(cliente);
	}
	
	public Cliente buscarClientePorId(int id) {
		return clienteGateway.buscarClientePorId(id);
	}

	public Cliente buscarClientePorCpf(String cpf) {
		return clienteGateway.buscarClientePorCpf(cpf);
	}

	public List<Cliente> buscarClientes() {
		return clienteGateway.buscarClientes();
	}
}
