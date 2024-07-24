package com.br.fiap.postech.soat7grupo5.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.postech.soat7grupo5.application.gateways.ProdutoGateway;
import com.br.fiap.postech.soat7grupo5.application.usecases.cliente.ProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.Produto.ProdutoDTOMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.ProdutoRepositoryGateway;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.ProdutoEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ProdutoRepository;

@Configuration
public class ProdutoConfig {

	@Bean
	ProdutoInteractor produtoInteractor(ProdutoGateway produtoGateway) {
		return new ProdutoInteractor(produtoGateway);
	}
	
	@Bean
	ProdutoGateway produtoGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
		return new ProdutoRepositoryGateway(produtoRepository, produtoEntityMapper);
	}
	
	@Bean
	ProdutoEntityMapper produtoEntityMapper() {
		return new ProdutoEntityMapper();
	}
	
	@Bean
	ProdutoDTOMapper produtoDTOMapper() {
		return new ProdutoDTOMapper();
	}
}
