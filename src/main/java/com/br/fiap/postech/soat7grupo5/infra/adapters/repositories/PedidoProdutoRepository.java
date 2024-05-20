package com.br.fiap.postech.soat7grupo5.infra.adapters.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.br.fiap.postech.soat7grupo5.domain.PedidoProduto;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.PedidoProdutoRepositoryPort;
import com.br.fiap.postech.soat7grupo5.infra.adapters.entities.PedidoProdutoEntity;

@Component
public class PedidoProdutoRepository implements PedidoProdutoRepositoryPort{

	private final PedidoProdutoRepositoryJpa pedidoProdutoRepositoryJpa;

	public PedidoProdutoRepository(PedidoProdutoRepositoryJpa pedidoProdutoRepositoryJpa) {
		this.pedidoProdutoRepositoryJpa = pedidoProdutoRepositoryJpa;
	}
	
	@Override
	public List<PedidoProduto> buscarTodos() {
		List<PedidoProdutoEntity> pedidoProdutoEntities = this.pedidoProdutoRepositoryJpa.findAll();
		return pedidoProdutoEntities.stream().map(PedidoProdutoEntity::toPedidoProduto).collect(Collectors.toList());
	}

	@Override
	public void salvarPedidoProdutos(List<PedidoProduto> pedidoProdutos) {
		List<PedidoProdutoEntity> pedidoProdutoEntities = new ArrayList<PedidoProdutoEntity>();
		for(PedidoProduto pedidoProduto : pedidoProdutos){
			PedidoProdutoEntity pedidoProdutoEntity = new PedidoProdutoEntity(pedidoProduto);
			pedidoProdutoEntities.add(pedidoProdutoEntity);
		}
		this.pedidoProdutoRepositoryJpa.saveAll(pedidoProdutoEntities);
	}

	@Override
	public List<PedidoProduto> buscarPedidoProdutosPorIdPedido(int idPedido) {
		List<PedidoProdutoEntity> pedidoProdutoEntities = this.pedidoProdutoRepositoryJpa.findByIdPedido(idPedido);
		return pedidoProdutoEntities.stream().map(PedidoProdutoEntity::toPedidoProduto).collect(Collectors.toList());
	}
}
