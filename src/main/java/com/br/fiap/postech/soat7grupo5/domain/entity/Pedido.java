package com.br.fiap.postech.soat7grupo5.domain.entity;

import java.util.Date;

import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido.PedidoResponse;

public class Pedido {

	private int idPedido;
	private Double preco;
	private int idStatusPedido;
	private int idCliente;
	private int idTipoPagamento;
	private int duracaoTotalPreparo;
	private Date dataCriacao;
	private int idStatusPagamento;
	
	public Pedido(int idPedido, Double preco, int idStatus, int idCliente, int idTipoPagamento, int duracaoTotalPreparo, Date dataCriacao, int idStatusPagamento) {
		this.idPedido = idPedido;
		this.preco = preco;
		this.idStatusPedido = idStatus;
		this.idCliente = idCliente;
		this.idTipoPagamento = idTipoPagamento;
		this.duracaoTotalPreparo = duracaoTotalPreparo;
		this.dataCriacao = dataCriacao;
		this.idStatusPagamento = idStatusPagamento;
	}

	public PedidoResponse toPedidoResponse() {
		return new PedidoResponse(this.idPedido, this.preco, this.idStatusPedido, this.idCliente, this.idTipoPagamento, this.duracaoTotalPreparo, this.dataCriacao, this.idStatusPagamento);
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public int getIdStatusPedido() {
		return idStatusPedido;
	}

	public void setIdStatusPedido(int idStatusPedido) {
		this.idStatusPedido = idStatusPedido;
	}

	public int getIdTipoPagamento() {
		return idTipoPagamento;
	}

	public void setIdTipoPagamento(int idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public int getIdStatusPagamento() {
		return idStatusPagamento;
	}

	public void setIdStatusPagamento(int idStatusPagamento) {
		this.idStatusPagamento = idStatusPagamento;
	}

}
