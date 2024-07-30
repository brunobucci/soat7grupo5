package com.br.fiap.postech.soat7grupo5.application.usecases.cliente;

import com.br.fiap.postech.soat7grupo5.application.gateways.ClienteGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

public class BuscarClientePorIdInteractor {

	private ClienteGateway clienteGateway;
	
	public BuscarClientePorIdInteractor(ClienteGateway clienteGateway) {
		this.clienteGateway = clienteGateway;
	}
	
	public Cliente buscarClientePorId(int id) {
		return clienteGateway.buscarClientePorId(id);
	}
}
