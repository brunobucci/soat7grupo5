package com.br.fiap.postech.soat7grupo5.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.Pedido;
import com.br.fiap.postech.soat7grupo5.domain.dtos.PedidoDTO;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.PedidoServicePort;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.PedidoRepositoryPort;

public class PedidoServiceImp implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepository;

    public PedidoServiceImp(PedidoRepositoryPort pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoDTO salvarPedido(PedidoDTO pedidoDTO) {
    	Pedido pedido = new Pedido(pedidoDTO);
    	return this.pedidoRepository.salvar(pedido).toPedidoDTO();
    }
    
    @Override
    public List<PedidoDTO> buscarPedidos() {
        List<Pedido> pedidos = this.pedidoRepository.buscarTodos();
        List<PedidoDTO> pedidosDTOS = pedidos.stream().map(Pedido::toPedidoDTO).collect(Collectors.toList());
        return pedidosDTOS;
    }

    @Override
    public PedidoDTO buscarPedidoPorId(int idPedido) {
    	Pedido pedido = this.pedidoRepository.buscarPorId(idPedido);
    	PedidoDTO pedidoDTO = pedido.toPedidoDTO();
		return pedidoDTO;
	}
    
    @Override
	public List<PedidoDTO> buscarPedidosPorStatus(int idStatus) {
    	List<Pedido> pedidos = this.pedidoRepository.buscarTodosPorStatus(idStatus);
        List<PedidoDTO> pedidoDTOS = pedidos.stream().map(Pedido::toPedidoDTO).collect(Collectors.toList());
        return pedidoDTOS;
	}
}