package com.br.fiap.postech.soat7grupo5.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.postech.soat7grupo5.application.gateways.ProdutoGateway;
import com.br.fiap.postech.soat7grupo5.application.usecases.produto.BuscarProdutosAtivosInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.produto.BuscarProdutosPorTipoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.produto.CriarProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.produto.DeletarProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.produto.EditarProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.produto.ProdutoDTOMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.ProdutoRepositoryGateway;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.ProdutoEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ProdutoRepository;

@Configuration
public class ProdutoConfig {

	@Bean
	CriarProdutoInteractor criarProdutoInteractor(ProdutoGateway produtoGateway) {
		return new CriarProdutoInteractor(produtoGateway);
	}
	
	@Bean
	BuscarProdutosAtivosInteractor buscarProdutosAtivosInteractor(ProdutoGateway produtoGateway) {
		return new BuscarProdutosAtivosInteractor(produtoGateway);
	}
	
	@Bean
	BuscarProdutosPorTipoInteractor buscarProdutosPorTipoInteractor(ProdutoGateway produtoGateway) {
		return new BuscarProdutosPorTipoInteractor(produtoGateway);
	}
	
	@Bean
	DeletarProdutoInteractor deletarProdutoInteractor(ProdutoGateway produtoGateway) {
		return new DeletarProdutoInteractor(produtoGateway);
	}
	
	@Bean
	EditarProdutoInteractor editarProdutoInteractor(ProdutoGateway produtoGateway) {
		return new EditarProdutoInteractor(produtoGateway);
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
