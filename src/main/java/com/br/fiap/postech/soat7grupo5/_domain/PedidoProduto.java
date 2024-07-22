package com.br.fiap.postech.soat7grupo5.domain;

import com.br.fiap.postech.soat7grupo5.domain.dtos.PedidoProdutoDTO;

public class PedidoProduto {

	private int idPedidoProduto;
	private int idPedido;
	private int idProduto;
    private Double precoProduto;
    private String nomeProduto;
    private int duracaoPreparo;
    

    public PedidoProduto(int idPedidoProduto, int idPedido, int idProduto, String nomeProduto, Double precoProduto, int duracaoPreparo) {
    	this.idPedidoProduto = idPedidoProduto;
    	this.idPedido = idPedido;
    	this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		this.duracaoPreparo = duracaoPreparo;
	}

    public int getIdPedidoProduto() {
		return idPedidoProduto;
	}

	public void setIdPedidoProduto(int idPedidoProduto) {
		this.idPedidoProduto = idPedidoProduto;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public int getDuracaoPreparo() {
		return duracaoPreparo;
	}

	public void setDuracaoPreparo(int duracaoPreparo) {
		this.duracaoPreparo = duracaoPreparo;
	}

	public PedidoProduto(PedidoProdutoDTO pedidoProdutoDTO) {
		this.idPedidoProduto = pedidoProdutoDTO.getIdPedidoProduto();
		this.idPedido = pedidoProdutoDTO.getIdPedido();
		this.idProduto = pedidoProdutoDTO.getIdProduto();
		this.nomeProduto = pedidoProdutoDTO.getNomeProduto();
		this.precoProduto = pedidoProdutoDTO.getPrecoProduto();
		this.duracaoPreparo = pedidoProdutoDTO.getDuracaoPreparo();
    }

	public PedidoProdutoDTO toPedidoProdutoDTO() {
        return new PedidoProdutoDTO(this.idPedidoProduto, this.idPedido, this.idProduto, this.nomeProduto, this.precoProduto, this.duracaoPreparo);
    }
}
