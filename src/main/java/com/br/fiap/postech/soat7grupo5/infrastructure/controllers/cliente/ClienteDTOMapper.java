package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.cliente;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

public class ClienteDTOMapper {

	ClienteResponse toResponse(Cliente cliente) {
		return new ClienteResponse(cliente.idCliente(), cliente.nome(), cliente.cpf(), cliente.email(), cliente.idCampanha());
	}
	
	Cliente toCliente(ClienteRequest request) {
		return new Cliente(request.idCliente(), request.nome(), request.cpf(), request.email(), request.idCampanha());
	}

	public List<ClienteResponse> toResponseList(List<Cliente> clientes) {
		return clientes.stream().map(Cliente::toClienteResponse).collect(Collectors.toList());
	}
	
}
