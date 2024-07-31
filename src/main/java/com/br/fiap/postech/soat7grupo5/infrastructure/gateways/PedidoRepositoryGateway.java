package com.br.fiap.postech.soat7grupo5.infrastructure.gateways;

import java.util.List;
import java.util.Optional;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido.StatusPagamentoConstantes;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.PedidoEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoEntity;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.PedidoRepository;

public class PedidoRepositoryGateway implements PedidoGateway{

	private final PedidoRepository pedidoRepository;
	private final PedidoEntityMapper pedidoEntityMapper;  
	
	public PedidoRepositoryGateway(PedidoRepository pedidoRepository, PedidoEntityMapper pedidoEntityMapper) {
		this.pedidoRepository = pedidoRepository;
		this.pedidoEntityMapper = pedidoEntityMapper;
	}
	
	@Override
	public Pedido criarPedido(Pedido pedidoDomainObj) {
		PedidoEntity pedidoEntity = pedidoEntityMapper.toEntity(pedidoDomainObj); 
		PedidoEntity savedObj = pedidoRepository.save(pedidoEntity);
		return pedidoEntityMapper.toDomainObj(savedObj); 
	}

	@Override
	public Pedido editarPedido(int idPedido, int idStatus) {
		Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(idPedido);
		pedidoEntity.get().setIdStatusPedido(idStatus);
		PedidoEntity savedObj = pedidoRepository.save(pedidoEntity.get());
		return pedidoEntityMapper.toDomainObj(savedObj);
	}

	@Override
	public List<Pedido> buscarPedidosPorStatus(int idStatus) {
		List<PedidoEntity> savedObjList = (List<PedidoEntity>) pedidoRepository.findByIdStatusPedido(idStatus);
		return pedidoEntityMapper.toDomainObjList(savedObjList); 
	}

	@Override
	public List<Pedido> buscarPedidos() {
		List<PedidoEntity> savedObjList = (List<PedidoEntity>) pedidoRepository.findAll();
		return pedidoEntityMapper.toDomainObjList(savedObjList); 
	}
	
	@Override
	public List<Pedido> buscarPedidosOrdenados() {
		List<PedidoEntity> savedObjList = (List<PedidoEntity>) pedidoRepository.findAllByIdStatusPedidoNotOrderByIdStatusPedidoDescDataCriacaoDesc(4);
		return pedidoEntityMapper.toDomainObjList(savedObjList); 
	}
	
	@Override
	public boolean buscarStatusPagamentoPedidoPorId(int idPedido) {
		Optional<PedidoEntity> savedObjList = pedidoRepository.findById(idPedido);
		return savedObjList.get().getIdStatusPagamento() == StatusPagamentoConstantes.PENDENTE || savedObjList.get().getIdStatusPagamento() == StatusPagamentoConstantes.REPROVADO ? false : true; 
	}
	
	@Override
	public Pedido buscarPedidoPorId(int idPedido) {
		Optional<PedidoEntity> savedObj = pedidoRepository.findById(idPedido);
		return pedidoEntityMapper.toDomainObj(savedObj.get());
	}
	
	@Override
	public Pedido atualizarStatusPagamento(int idPedido, int idStatusPagamento) {
		Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(idPedido);
		pedidoEntity.get().setIdStatusPagamento(idStatusPagamento);
		PedidoEntity savedObj = pedidoRepository.save(pedidoEntity.get());
		return pedidoEntityMapper.toDomainObj(savedObj);
	}
}