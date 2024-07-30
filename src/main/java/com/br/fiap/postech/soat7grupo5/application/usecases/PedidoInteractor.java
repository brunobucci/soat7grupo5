package com.br.fiap.postech.soat7grupo5.application.usecases;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.application.gateways.PedidoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;

public class PedidoInteractor {

	
	private PedidoGateway pedidoGateway;
	
	public PedidoInteractor(PedidoGateway pedidoGateway) {
		this.pedidoGateway = pedidoGateway;
	}
	
	public Pedido criarPedido(Pedido pedido) {
		return pedidoGateway.criarPedido(pedido);
	}
	
	public Pedido editarPedido(int idPedido, int idStatusPedido) {
		return pedidoGateway.editarPedido(idPedido, idStatusPedido);
	}

	public List<Pedido> buscarPedidosPorStatus(int idStatus) {
		return pedidoGateway.buscarPedidosPorStatus(idStatus);
	}

	public List<Pedido> buscarPedidos() {
		return pedidoGateway.buscarPedidos();
	}

	public boolean buscarStatusPagamentoPedidoPorId(int idPedido) {
		return pedidoGateway.buscarStatusPagamentoPedidoPorId(idPedido);
	}

	public List<Pedido> buscarPedidosOrdenados() {
		return pedidoGateway.buscarPedidosOrdenados();
	}

	public Pedido buscarPedidoPorId(int idPedido) {
		return pedidoGateway.buscarPedidoPorId(idPedido);
	}
	
	public Pedido atualizarStatusPagamento(int idPedido, int idStatusPagamento) {
		return pedidoGateway.atualizarStatusPagamento(idPedido, idStatusPagamento);
	}
}
