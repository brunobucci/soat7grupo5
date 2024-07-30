package com.br.fiap.postech.soat7grupo5.application.usecases;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;

public class PedidoProdutoInteractor {

	private PedidoProdutoGateway pedidoProdutoGateway;
	
	public PedidoProdutoInteractor(PedidoProdutoGateway pedidoProdutoGateway) {
		this.pedidoProdutoGateway = pedidoProdutoGateway;
	}
	
	public List<PedidoProduto> buscarPedidoProdutos(){
		return pedidoProdutoGateway.buscarPedidoProdutos();
		
	}
	
	public void salvarPedidoProduto(int idPedido, List<PedidoProduto> pedidoProdutos) {
		
//		List<PedidoProduto> pedidoProdutos = new ArrayList<PedidoProduto>();
		
		for(PedidoProduto pedidoProduto : pedidoProdutos) {
			
			pedidoProduto.setIdPedido(idPedido);
			
//			PedidoProduto pedidoProdutoAtualizado = new PedidoProduto(pedidoProduto);
//			pedidoProdutoAtualizado.setIdPedido(idPedido);
//			pedidoProdutos.add(pedidoProduto);			
		}
		
		pedidoProdutoGateway.salvarPedidoProduto(pedidoProdutos);
	}
	
	public List<PedidoProduto> buscarPedidoProdutosPorIdPedido(int idPedido){
		return pedidoProdutoGateway.buscarPedidoProdutosPorIdPedido(idPedido);
		
	}
	
}