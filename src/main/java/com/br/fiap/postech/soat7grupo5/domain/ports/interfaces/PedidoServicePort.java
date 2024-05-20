package com.br.fiap.postech.soat7grupo5.domain.ports.interfaces;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.dtos.PedidoDTO;

public interface PedidoServicePort {
	
	List<PedidoDTO> buscarPedidos();

	List<PedidoDTO> buscarPedidosPorStatus(int idStatus);

	PedidoDTO buscarPedidoPorId(int idPedido);

	PedidoDTO salvarPedido(PedidoDTO pedidoDTO);

    //void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws NotFoundException;
}