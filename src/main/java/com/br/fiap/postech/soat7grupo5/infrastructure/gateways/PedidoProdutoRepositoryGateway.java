package com.br.fiap.postech.soat7grupo5.infrastructure.gateways;

import java.util.ArrayList;
import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.PedidoProdutoEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoProdutoEntity;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoProdutoRepository;

public class PedidoProdutoRepositoryGateway implements PedidoProdutoGateway{

	
	private final PedidoProdutoRepository pedidoProdutoRepository;
	private final PedidoProdutoEntityMapper pedidoProdutoEntityMapper;  
	
	public PedidoProdutoRepositoryGateway(PedidoProdutoRepository pedidoProdutoRepository, PedidoProdutoEntityMapper pedidoProdutoEntityMapper) {
		this.pedidoProdutoRepository = pedidoProdutoRepository;
		this.pedidoProdutoEntityMapper = pedidoProdutoEntityMapper;
	}
	
	@Override
	public List<PedidoProduto> buscarPedidoProdutos() {
		List<PedidoProdutoEntity> savedObjList = (List<PedidoProdutoEntity>) pedidoProdutoRepository.findAll();
		return pedidoProdutoEntityMapper.toDomainObjList(savedObjList); 
	}
	@Override
	public List<PedidoProduto> buscarPedidoProdutosPorIdPedido(int idPedido) {
		List<PedidoProdutoEntity> savedObjList = (List<PedidoProdutoEntity>) pedidoProdutoRepository.findByIdPedido(idPedido);
		return pedidoProdutoEntityMapper.toDomainObjList(savedObjList); 
	}
	@Override
	public void salvarPedidoProduto(List<PedidoProduto> pedidoProdutos) {
		List<PedidoProdutoEntity> pedidoProdutoEntities = new ArrayList<PedidoProdutoEntity>();
		for(PedidoProduto pedidoProduto : pedidoProdutos){
			PedidoProdutoEntity pedidoProdutoEntity = new PedidoProdutoEntity(pedidoProduto);
			pedidoProdutoEntities.add(pedidoProdutoEntity);
		}
		pedidoProdutoRepository.saveAll(pedidoProdutoEntities);
	}
}
