package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.cliente;

public record ClienteRequest(int idCliente, String nome, String cpf, String email, int idCampanha) {

}
