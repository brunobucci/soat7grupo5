package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.cliente;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.BuscarClientePorCpfInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.BuscarClientePorIdInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.BuscarClientesInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.CriarClienteInteractor;
import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Clientes", description = "Recursos relacionados aos clientes.")
@RequestMapping(path="clientes", produces=MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	private final CriarClienteInteractor criarClienteInteractor;
	private final BuscarClientePorCpfInteractor buscarClientePorCpfInteractor;
	private final BuscarClientePorIdInteractor buscarClientePorIdInteractor;
	private final BuscarClientesInteractor buscarClientesInteractor;
	private final ClienteDTOMapper clienteDTOMapper;
	
    public ClienteController(CriarClienteInteractor criarClienteInteractor, BuscarClientePorCpfInteractor buscarClientePorCpfInteractor, BuscarClientePorIdInteractor buscarClientePorIdInteractor, BuscarClientesInteractor buscarClientesInteractor, ClienteDTOMapper clienteDTOMapper) {
        this.criarClienteInteractor = criarClienteInteractor;
        this.buscarClientePorCpfInteractor = buscarClientePorCpfInteractor;
        this.buscarClientePorIdInteractor = buscarClientePorIdInteractor;
        this.buscarClientesInteractor = buscarClientesInteractor;
        this.clienteDTOMapper = clienteDTOMapper;
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro do cliente.")
    ClienteResponse criarCliente(@RequestBody ClienteRequest request) {
    	Cliente clienteBusinessObj = clienteDTOMapper.toCliente(request);
    	Cliente cliente = criarClienteInteractor.criarCliente(clienteBusinessObj);
    	return clienteDTOMapper.toResponse(cliente);
    }

    @GetMapping
    @Operation(summary = "Retorna lista com todos os clientes cadastrados.")
    List<ClienteResponse> buscarClientes() {
    	List<Cliente> clientes = buscarClientesInteractor.buscarClientes();
    	return clienteDTOMapper.toResponseList(clientes);
    }
    
    @GetMapping(path="/{idCliente}")
    @Operation(summary = "Busca o cliente cadastrado por id.")
    ClienteResponse buscarClientePorId(@Parameter(description = "ID do cliente", example = "1") @PathVariable int idCliente) {
    	Cliente cliente = buscarClientePorIdInteractor.buscarClientePorId(idCliente);
    	return clienteDTOMapper.toResponse(cliente);
    }
	
    @GetMapping(path="/buscar-por-cpf/{cpf}")
    @Operation(summary = "Busca o cliente cadastrado por cpf.")
    ClienteResponse buscarClientePorCpf(@Parameter(description = "CPF do cliente, apenas números.", example = "11122233344") @PathVariable String cpf) {
    	Cliente cliente = buscarClientePorCpfInteractor.buscarClientePorCpf(cpf);
    	return clienteDTOMapper.toResponse(cliente);
    }
}
