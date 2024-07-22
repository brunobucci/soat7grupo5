package com.br.fiap.postech.soat7grupo5.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.Cliente;
import com.br.fiap.postech.soat7grupo5.domain.dtos.ClienteDTO;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.ClienteServicePort;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.ClienteRepositoryPort;

public class ClienteServiceImp implements ClienteServicePort {

    private final ClienteRepositoryPort clienteRepository;

    public ClienteServiceImp(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

	@Override
	public void criarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO);
		this.clienteRepository.salvar(cliente);
	}

	@Override
	public List<ClienteDTO> buscarClientes() {
		List<Cliente> clientes = this.clienteRepository.buscarTodos();
        List<ClienteDTO> clientesDTOS = clientes.stream().map(Cliente::toClienteDTO).collect(Collectors.toList());
        return clientesDTOS;
	}

	@Override
	public ClienteDTO buscarClientePorId(int idCliente) {
		Cliente cliente = this.clienteRepository.buscarPorId(idCliente);
		ClienteDTO clienteDTO = cliente.toClienteDTO();
		return clienteDTO;
	}
	
	@Override
	public ClienteDTO buscarClientePorCpf(String cpf) {
		Cliente cliente = this.clienteRepository.buscarPorCpf(cpf);
		ClienteDTO clienteDTO = cliente.toClienteDTO();
		return clienteDTO;
	}
    
}