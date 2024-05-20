package com.br.fiap.postech.soat7grupo5.domain.ports.repositories;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.Cliente;

public interface ClienteRepositoryPort {
	void salvar(Cliente cliente);
	List<Cliente> buscarTodos();
	Cliente buscarPorCpf(String cpf);
	Cliente buscarPorId(int idCliente);
}
