package com.br.fiap.postech.soat7grupo5.domain.ports.repositories;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.Pedido;

public interface PedidoRepositoryPort {
    List<Pedido> buscarTodos();
    Pedido buscarPorId(int idPedido);
    List<Pedido> buscarTodosPorStatus(int idStatus);
	Pedido salvar(Pedido pedido);
}
