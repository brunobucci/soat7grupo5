package com.br.fiap.postech.soat7grupo5.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;
import com.br.fiap.postech.soat7grupo5.application.usecases.PedidoInteractor;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido.PedidoDTOMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.PedidoRepositoryGateway;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.PedidoEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoRepository;

@Configuration
public class PedidoConfig {

	@Bean
	PedidoInteractor pedidoInteractor(PedidoGateway pedidoGateway) {
		return new PedidoInteractor(pedidoGateway);
	}
	
	@Bean
	PedidoGateway pedidoGateway(PedidoRepository pedidoRepository, PedidoEntityMapper pedidoEntityMapper) {
		return new PedidoRepositoryGateway(pedidoRepository, pedidoEntityMapper);
	}
	
	@Bean
	PedidoEntityMapper pedidoEntityMapper() {
		return new PedidoEntityMapper();
	}
	
	@Bean
	PedidoDTOMapper pedidoDTOMapper() {
		return new PedidoDTOMapper();
	}
}
