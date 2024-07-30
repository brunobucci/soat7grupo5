package com.br.fiap.postech.soat7grupo5.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoProdutoGateway;
import com.br.fiap.postech.soat7grupo5.application.usecases.PedidoProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido.PedidoProdutoDTOMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.PedidoProdutoRepositoryGateway;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.PedidoProdutoEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoProdutoRepository;

@Configuration
public class PedidoProdutoConfig {

	@Bean
	PedidoProdutoInteractor pedidoProdutoInteractor(PedidoProdutoGateway pedidoProdutoGateway) {
		return new PedidoProdutoInteractor(pedidoProdutoGateway);
	}
	
	@Bean
	PedidoProdutoGateway pedidoProdutoGateway(PedidoProdutoRepository pedidoProdutoRepository, PedidoProdutoEntityMapper pedidoProdutoEntityMapper) {
		return new PedidoProdutoRepositoryGateway(pedidoProdutoRepository, pedidoProdutoEntityMapper);
	}
	
	@Bean
	PedidoProdutoEntityMapper pedidoProdutoEntityMapper() {
		return new PedidoProdutoEntityMapper();
	}
	
	@Bean
	PedidoProdutoDTOMapper pedidoProdutoDTOMapper() {
		return new PedidoProdutoDTOMapper();
	}
}
