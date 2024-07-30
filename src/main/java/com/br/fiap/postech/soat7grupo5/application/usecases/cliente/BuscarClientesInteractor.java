package com.br.fiap.postech.soat7grupo5.application.usecases.cliente;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.ClienteGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

public class BuscarClientesInteractor {

private ClienteGateway clienteGateway;
	
	public BuscarClientesInteractor(ClienteGateway clienteGateway) {
		this.clienteGateway = clienteGateway;
	}
	
	public List<Cliente> buscarClientes() {
		return clienteGateway.buscarClientes();
	}
}
