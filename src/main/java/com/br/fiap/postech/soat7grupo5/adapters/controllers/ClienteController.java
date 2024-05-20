package com.br.fiap.postech.soat7grupo5.adapters.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5.domain.dtos.ClienteDTO;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.ClienteServicePort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Clientes", description = "Recursos relacionados aos clientes.")
@RequestMapping(path="clientes", produces=MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	private final ClienteServicePort clienteServicePort;

    public ClienteController(ClienteServicePort clienteServicePort) {
        this.clienteServicePort = clienteServicePort;
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro do cliente.")
    void criarCliente(@RequestBody ClienteDTO ClienteDTO) {
        clienteServicePort.criarCliente(ClienteDTO);
    }

    @GetMapping
    @Operation(summary = "Retorna lista com todos os clientes cadastrados.")
    List<ClienteDTO> buscarClientes() {
        return clienteServicePort.buscarClientes();
    }
    
    @GetMapping(path="/{idCliente}")
    @Operation(summary = "Busca o cliente cadastrado por id.")
    ClienteDTO buscarClientePorId(@Parameter(description = "ID do cliente", example = "1") @PathVariable int idCliente) {
        return clienteServicePort.buscarClientePorId(idCliente);
    }
	
    @GetMapping(path="/buscar-por-cpf/{cpf}")
    @Operation(summary = "Busca o cliente cadastrado por cpf.")
    ClienteDTO buscarClientePorCpf(@Parameter(description = "CPF do cliente, apenas números.", example = "11122233344") @PathVariable String cpf) {
        return clienteServicePort.buscarClientePorCpf(cpf);
    }
}
