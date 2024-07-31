package com.br.fiap.postech.soat7grupo5.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;
import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoProdutoGateway;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.AtualizarStatusPagamentoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarPedidoPorIdInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarPedidosInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarPedidosOrdenadosInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarPedidosPorStatusInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarStatusPagamentoPedidoPorIdInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.CriarPedidoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.EditarPedidoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedidoproduto.BuscarPedidoProdutoPorIdPedidoInteractor;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido.PedidoDTOMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.PedidoRepositoryGateway;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.PedidoEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoRepository;

@Configuration
public class PedidoConfig {

	@Bean
	CriarPedidoInteractor criarPedidoInteractor(PedidoGateway pedidoGateway) {
		return new CriarPedidoInteractor(pedidoGateway);
	}
	
	@Bean
	EditarPedidoInteractor editarPedidoInteractor(PedidoGateway pedidoGateway) {
		return new EditarPedidoInteractor(pedidoGateway);
	}
	
	@Bean
	BuscarPedidosPorStatusInteractor buscarPedidosPorStatusInteractor(PedidoGateway pedidoGateway) {
		return new BuscarPedidosPorStatusInteractor(pedidoGateway);
	}
	
	@Bean
	BuscarPedidosInteractor buscarPedidosInteractor(PedidoGateway pedidoGateway) {
		return new BuscarPedidosInteractor(pedidoGateway);
	}
	
	@Bean
	BuscarPedidoPorIdInteractor buscarPedidoPorIdInteractor(PedidoGateway pedidoGateway) {
		return new BuscarPedidoPorIdInteractor(pedidoGateway);
	}
	
	@Bean
	BuscarStatusPagamentoPedidoPorIdInteractor buscarStatusPagamentoPedidoPorIdInteractor(PedidoGateway pedidoGateway) {
		return new BuscarStatusPagamentoPedidoPorIdInteractor(pedidoGateway);
	}
	
	@Bean
	BuscarPedidosOrdenadosInteractor buscarPedidosOrdenadosInteractor(PedidoGateway pedidoGateway) {
		return new BuscarPedidosOrdenadosInteractor(pedidoGateway);
	}
	
	@Bean
	AtualizarStatusPagamentoInteractor atualizarStatusPagamentoInteractor(PedidoGateway pedidoGateway) {
		return new AtualizarStatusPagamentoInteractor(pedidoGateway);
	}
	
	@Bean
	BuscarPedidoProdutoPorIdPedidoInteractor buscarPedidoProdutoPorIdPedidoInteractor(PedidoProdutoGateway pedidoProdutoGateway) {
		return new BuscarPedidoProdutoPorIdPedidoInteractor(pedidoProdutoGateway);
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
