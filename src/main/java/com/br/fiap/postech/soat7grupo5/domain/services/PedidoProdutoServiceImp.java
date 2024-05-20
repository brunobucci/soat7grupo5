package com.br.fiap.postech.soat7grupo5.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.PedidoProduto;
import com.br.fiap.postech.soat7grupo5.domain.dtos.PedidoProdutoDTO;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.PedidoProdutoServicePort;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.PedidoProdutoRepositoryPort;

public class PedidoProdutoServiceImp implements PedidoProdutoServicePort{

	private final PedidoProdutoRepositoryPort pedidoProdutoRepository;

	public PedidoProdutoServiceImp(PedidoProdutoRepositoryPort pedidoProdutoRepository) {
		this.pedidoProdutoRepository = pedidoProdutoRepository;
	}

	@Override
	public List<PedidoProdutoDTO> buscarPedidoProdutos() {
		List<PedidoProduto> pedidoProdutos = this.pedidoProdutoRepository.buscarTodos();
		List<PedidoProdutoDTO> produtoDTOS = pedidoProdutos.stream().map(PedidoProduto::toPedidoProdutoDTO).collect(Collectors.toList());
		return produtoDTOS;
	}

	@Override
	public void salvarPedidoProduto(int idPedido, List<PedidoProdutoDTO> pedidoProdutoDTOs) {
		List<PedidoProduto> pedidoProdutos = new ArrayList<PedidoProduto>();
		for(PedidoProdutoDTO pedidoProdutoDTO : pedidoProdutoDTOs) {
			PedidoProduto pedidoProduto = new PedidoProduto(pedidoProdutoDTO);
			pedidoProduto.setIdPedido(idPedido);
			pedidoProdutos.add(pedidoProduto);			
		}
		this.pedidoProdutoRepository.salvarPedidoProdutos(pedidoProdutos);
	}

	@Override
	public List<PedidoProdutoDTO> buscarPedidoProdutosPorIdPedido(int idPedido) {
		List<PedidoProduto> pedidoProdutos = this.pedidoProdutoRepository.buscarPedidoProdutosPorIdPedido(idPedido);
		List<PedidoProdutoDTO> pedidoProdutoDTOS = pedidoProdutos.stream().map(PedidoProduto::toPedidoProdutoDTO).collect(Collectors.toList());
		return pedidoProdutoDTOS;
	}
}
