package com.br.fiap.postech.soat7grupo5.application.gateways;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

public interface ClienteGateway {

	Cliente criarCliente(Cliente cliente);
	Cliente buscarClientePorId(int id);
	Cliente buscarClientePorCpf(String cpf);
	List<Cliente> buscarClientes();
	
}
