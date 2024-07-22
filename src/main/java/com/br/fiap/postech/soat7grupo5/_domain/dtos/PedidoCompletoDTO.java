package com.br.fiap.postech.soat7grupo5.domain.dtos;

import java.util.List;

public class PedidoCompletoDTO {

	private PedidoDTO pedidoDTO;
	private List<PedidoProdutoDTO> pedidoProdutoDTOs;
	
	public PedidoDTO getPedidoDTO() {
		return pedidoDTO;
	}
	public void setPedidoDTO(PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
	}
	public List<PedidoProdutoDTO> getPedidoProdutoDTOs() {
		return pedidoProdutoDTOs;
	}
	public void setPedidoProdutoDTOs(List<PedidoProdutoDTO> pedidoProdutoDTOs) {
		this.pedidoProdutoDTOs = pedidoProdutoDTOs;
	}
}
