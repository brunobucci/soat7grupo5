package com.br.fiap.postech.soat7grupo5.infra.adapters.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.br.fiap.postech.soat7grupo5.domain.Pedido;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.PedidoRepositoryPort;
import com.br.fiap.postech.soat7grupo5.infra.adapters.entities.PedidoEntity;

@Component
public class PedidoRepository implements PedidoRepositoryPort{
	
	private final PedidoRepositoryJpa pedidoRepositoryJpa;

	public PedidoRepository(PedidoRepositoryJpa pedidoRepositoryJpa) {
		this.pedidoRepositoryJpa = pedidoRepositoryJpa;
	}
	
	@Override
	public List<Pedido> buscarTodos() {
		List<PedidoEntity> pedidoEntities = this.pedidoRepositoryJpa.findAll();
		return pedidoEntities.stream().map(PedidoEntity::toPedido).collect(Collectors.toList());
	}

	@Override
	public Pedido buscarPorId(int idPedido) {
		Optional<PedidoEntity> pedidoEntity = this.pedidoRepositoryJpa.findById(idPedido);
		if (pedidoEntity.isPresent())
			return pedidoEntity.get().toPedido();

		throw new RuntimeException("Pedido não existe");
	}

	@Override
	public List<Pedido> buscarTodosPorStatus(int idStatus) {
		List<PedidoEntity> pedidoEntities = this.pedidoRepositoryJpa.findByIdStatus(idStatus);
		return pedidoEntities.stream().map(PedidoEntity::toPedido).collect(Collectors.toList());
	}

	@Override
	public Pedido salvar(Pedido pedido) {
		PedidoEntity pedidoEntity;
        if (pedido.getIdPedido() == 0)
        	pedidoEntity = new PedidoEntity(pedido);
        else {
        	pedidoEntity = this.pedidoRepositoryJpa.findById(pedido.getIdPedido()).get();
        	pedidoEntity.atualizar(pedido);
        }
        return this.pedidoRepositoryJpa.save(pedidoEntity).toPedido();
		
	}

	
}
