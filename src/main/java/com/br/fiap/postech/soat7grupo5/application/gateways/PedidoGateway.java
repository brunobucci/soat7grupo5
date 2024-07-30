package com.br.fiap.postech.soat7grupo5.application.gateways;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;

public interface PedidoGateway {

	Pedido criarPedido(Pedido pedido);
	Pedido editarPedido(int idPedido, int idStatus);
	List<Pedido> buscarPedidosPorStatus(int idStatus);	
	List<Pedido> buscarPedidos();
	boolean buscarStatusPagamentoPedidoPorId(int idPedido);
	List<Pedido> buscarPedidosOrdenados();
	Pedido buscarPedidoPorId(int idPedido);
	Pedido atualizarStatusPagamento(int idPedido, int idStatusPagamento);

}
