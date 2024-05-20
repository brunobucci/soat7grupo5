package com.br.fiap.postech.soat7grupo5.domain.ports.interfaces;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.dtos.ClienteDTO;

public interface ClienteServicePort {

    void criarCliente(ClienteDTO clienteDTO);

	List<ClienteDTO> buscarClientes();
	ClienteDTO buscarClientePorCpf(String cpf);
	ClienteDTO buscarClientePorId(int idCliente);

}
