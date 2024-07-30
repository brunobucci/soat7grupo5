package com.br.fiap.postech.soat7grupo5.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.postech.soat7grupo5.application.gateways.ClienteGateway;
import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.BuscarClientePorCpfInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.BuscarClientePorIdInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.BuscarClientesInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.CriarClienteInteractor;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.cliente.ClienteDTOMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.ClienteRepositoryGateway;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.ClienteEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ClienteRepository;

@Configuration
public class ClienteConfig {

	@Bean
	CriarClienteInteractor criarClienteInteractor(ClienteGateway clienteGateway) {
		return new CriarClienteInteractor(clienteGateway);
	}
	
	@Bean
	BuscarClientePorCpfInteractor buscarClientePorCpfInteractor(ClienteGateway clienteGateway) {
		return new BuscarClientePorCpfInteractor(clienteGateway);
	}
	
	@Bean
	BuscarClientePorIdInteractor buscarClientePorIdInteractor(ClienteGateway clienteGateway) {
		return new BuscarClientePorIdInteractor(clienteGateway);
	}
	
	@Bean
	BuscarClientesInteractor buscarClientesInteractor(ClienteGateway clienteGateway) {
		return new BuscarClientesInteractor(clienteGateway);
	}
	
	@Bean
	ClienteGateway clienteGateway(ClienteRepository clienteRepository, ClienteEntityMapper clienteEntityMapper) {
		return new ClienteRepositoryGateway(clienteRepository, clienteEntityMapper);
	}
	
	@Bean
	ClienteEntityMapper clienteEntityMapper() {
		return new ClienteEntityMapper();
	}
	
	@Bean
	ClienteDTOMapper clienteDTOMapper() {
		return new ClienteDTOMapper();
	}
}
