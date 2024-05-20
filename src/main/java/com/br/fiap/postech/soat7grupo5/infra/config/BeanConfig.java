package com.br.fiap.postech.soat7grupo5.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.ClienteServicePort;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.PedidoProdutoServicePort;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.PedidoServicePort;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.ProdutoServicePort;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.ClienteRepositoryPort;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.PedidoProdutoRepositoryPort;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.PedidoRepositoryPort;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.ProdutoRepositoryPort;
import com.br.fiap.postech.soat7grupo5.domain.services.ClienteServiceImp;
import com.br.fiap.postech.soat7grupo5.domain.services.PedidoProdutoServiceImp;
import com.br.fiap.postech.soat7grupo5.domain.services.PedidoServiceImp;
import com.br.fiap.postech.soat7grupo5.domain.services.ProdutoServiceImp;

@Configuration
public class BeanConfig {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ProdutoServiceImp(produtoRepositoryPort);
    }
    @Bean
    ClienteServicePort clienteService(ClienteRepositoryPort clienteRepositoryPort) {
        return new ClienteServiceImp(clienteRepositoryPort);
    }
    @Bean
    PedidoServicePort pedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        return new PedidoServiceImp(pedidoRepositoryPort);
    }
    @Bean
    PedidoProdutoServicePort pedidoProdutoService(PedidoProdutoRepositoryPort pedidoProdutoRepositoryPort) {
        return new PedidoProdutoServiceImp(pedidoProdutoRepositoryPort);
    }
}