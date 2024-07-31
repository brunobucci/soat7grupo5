package com.br.fiap.postech.soat7grupo5.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoProdutoGateway;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedidoproduto.SalvarPedidoProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.PedidoProdutoRepositoryGateway;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.PedidoProdutoEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoProdutoRepository;

@Configuration
public class PedidoProdutoConfig {

	@Bean
	SalvarPedidoProdutoInteractor salvarPedidoProdutoInteractor(PedidoProdutoGateway pedidoProdutoGateway) {
		return new SalvarPedidoProdutoInteractor(pedidoProdutoGateway);
	}
	
	@Bean
	PedidoProdutoGateway pedidoProdutoGateway(PedidoProdutoRepository pedidoProdutoRepository, PedidoProdutoEntityMapper pedidoProdutoEntityMapper) {
		return new PedidoProdutoRepositoryGateway(pedidoProdutoRepository, pedidoProdutoEntityMapper);
	}
	
	@Bean
	PedidoProdutoEntityMapper pedidoProdutoEntityMapper() {
		return new PedidoProdutoEntityMapper();
	}
	
}
