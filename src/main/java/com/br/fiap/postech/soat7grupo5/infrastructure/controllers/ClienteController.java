package com.br.fiap.postech.soat7grupo5.infrastructure.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.ClienteInteractor;
import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Clientes", description = "Recursos relacionados aos clientes.")
@RequestMapping(path="clientes", produces=MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	private final ClienteInteractor clienteInteractor; 
	private final ClienteDTOMapper clienteDTOMapper;
	
    public ClienteController(ClienteInteractor clienteInteractor, ClienteDTOMapper clienteDTOMapper) {
        this.clienteInteractor = clienteInteractor;
        this.clienteDTOMapper = clienteDTOMapper;
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro do cliente.")
    ClienteResponse criarCliente(@RequestBody ClienteRequest request) {
    	Cliente clienteBusinessObj = clienteDTOMapper.toCliente(request);
    	Cliente cliente = clienteInteractor.criarCliente(clienteBusinessObj);
    	return clienteDTOMapper.toResponse(cliente);
    }

    @GetMapping
    @Operation(summary = "Retorna lista com todos os clientes cadastrados.")
    List<ClienteResponse> buscarClientes() {
    	List<Cliente> clientes = clienteInteractor.buscarClientes();
    	return clienteDTOMapper.toResponseList(clientes);
    }
    
    @GetMapping(path="/{idCliente}")
    @Operation(summary = "Busca o cliente cadastrado por id.")
    ClienteResponse buscarClientePorId(@Parameter(description = "ID do cliente", example = "1") @PathVariable int idCliente) {
    	Cliente cliente = clienteInteractor.buscarClientePorId(idCliente);
    	return clienteDTOMapper.toResponse(cliente);
    }
	
    @GetMapping(path="/buscar-por-cpf/{cpf}")
    @Operation(summary = "Busca o cliente cadastrado por cpf.")
    ClienteResponse buscarClientePorCpf(@Parameter(description = "CPF do cliente, apenas números.", example = "11122233344") @PathVariable String cpf) {
    	Cliente cliente = clienteInteractor.buscarClientePorCpf(cpf);
    	return clienteDTOMapper.toResponse(cliente);
    }
}
