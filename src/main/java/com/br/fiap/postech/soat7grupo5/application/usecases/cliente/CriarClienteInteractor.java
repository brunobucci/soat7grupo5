package com.br.fiap.postech.soat7grupo5.application.usecases.cliente;

import com.br.fiap.postech.soat7grupo5.application.gateways.ClienteGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

public class CriarClienteInteractor {

	private ClienteGateway clienteGateway;

	public CriarClienteInteractor(ClienteGateway clienteGateway) {
		this.clienteGateway = clienteGateway;
	}

	public Cliente criarCliente(Cliente cliente) {
		return clienteGateway.criarCliente(cliente);
	}
}
