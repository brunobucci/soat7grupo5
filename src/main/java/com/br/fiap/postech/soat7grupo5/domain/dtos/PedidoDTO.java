package com.br.fiap.postech.soat7grupo5.domain.dtos;

import java.util.Date;

public class PedidoDTO {

	private int idPedido;
	private Double preco;
	private int idStatus;
	private int idCliente;
	private int idPagamento;
	private int duracaoTotalPreparo;
	private Date dataCriacao;
	
	public PedidoDTO(int idPedido, Double preco, int idStatus, int idCliente, int idPagamento, int duracaoTotalPreparo, Date dataCriacao) {
		this.idPedido = idPedido;
		this.preco = preco;
		this.idStatus = idStatus;
		this.idCliente = idCliente;
		this.idPagamento = idPagamento;
		this.duracaoTotalPreparo = duracaoTotalPreparo;
		this.dataCriacao = dataCriacao;
	}

	public PedidoDTO(int idPedido2, int idStatus2) {
		this.idPedido = idPedido2;
		this.idStatus = idStatus2;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	public int getDuracaoTotalPreparo() {
		return duracaoTotalPreparo;
	}

	public void setDuracaoTotalPreparo(int duracaoTotalPreparo) {
		this.duracaoTotalPreparo = duracaoTotalPreparo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}