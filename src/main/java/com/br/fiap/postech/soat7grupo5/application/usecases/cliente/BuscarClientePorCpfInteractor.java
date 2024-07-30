package com.br.fiap.postech.soat7grupo5.application.usecases.cliente;

import com.br.fiap.postech.soat7grupo5.application.gateways.ClienteGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

public class BuscarClientePorCpfInteractor {

	private ClienteGateway clienteGateway;
	
	public BuscarClientePorCpfInteractor(ClienteGateway clienteGateway) {
		this.clienteGateway = clienteGateway;
	}

	public Cliente buscarClientePorCpf(String cpf) {
		return clienteGateway.buscarClientePorCpf(cpf);
	}
}
