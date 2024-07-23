package com.br.fiap.postech.soat7grupo5.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.postech.soat7grupo5.application.gateways.ClienteGateway;
import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.ClienteInteractor;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.ClienteDTOMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.ClienteRepositoryGateway;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.ClienteEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ClienteRepository;

@Configuration
public class ClienteConfig {

	@Bean
	ClienteInteractor criarClienteInteractor(ClienteGateway clienteGateway) {
		return new ClienteInteractor(clienteGateway);
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
