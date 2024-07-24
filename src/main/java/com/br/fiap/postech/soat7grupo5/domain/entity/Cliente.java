package com.br.fiap.postech.soat7grupo5.domain.entity;

import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.cliente.ClienteResponse;

public record Cliente(int idCliente, String nome, String cpf, String email, int idCampanha) {

	public ClienteResponse toClienteResponse() {
		return new ClienteResponse(this.idCliente, this.cpf, this.nome, this.email, this.idCampanha);
	}
}
