package com.br.fiap.postech.soat7grupo5.infrastructure.persistence;

import java.util.Date;

import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPedido;
	private Double preco;
	private int idStatusPedido;
	private int idCliente;
	private int idTipoPagamento;
	private int duracaoTotalPreparo;
	private Date dataCriacao;
	private int idStatusPagamento;
	
	public PedidoEntity() {
	}
	
	public PedidoEntity(int idPedido, Double preco, int idStatus, int idCliente, int idPagamento, int duracaoTotalPreparo, Date dataCriacao, int idStatusPagamento) {
		super();
		this.idPedido = idPedido;
		this.preco = preco;
		this.idStatusPedido = idStatus;
		this.idCliente = idCliente;
		this.idTipoPagamento = idPagamento;
		this.duracaoTotalPreparo = duracaoTotalPreparo;
		this.dataCriacao = dataCriacao;
		this.idStatusPagamento = idStatusPagamento;
	}
	
//	public void atualizar(Pedido pedido) {
//		this.preco = Objects.nonNull(pedido.getPreco()) ? pedido.getPreco() : this.preco;
//		this.idStatus = (pedido.getIdStatus() != 0) ? pedido.getIdStatus() : this.idStatus;
//		this.idCliente = (pedido.getIdCliente() != 0) ? pedido.getIdCliente() : this.idCliente;
//		this.idPagamento = (pedido.getIdPagamento() != 0) ? pedido.getIdPagamento() : this.idPagamento;
//		this.duracaoTotalPreparo = (pedido.getDuracaoTotalPreparo() != 0) ? pedido.getDuracaoTotalPreparo() : this.duracaoTotalPreparo;
//	}
	
	public Pedido toPedido() {
		return new Pedido(this.idPedido, this.preco, this.idStatusPedido, this.idCliente, this.idTipoPagamento, this.duracaoTotalPreparo, this.dataCriacao, this.idStatusPagamento);
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

	public int getIdStatusPedido() {
		return idStatusPedido;
	}

	public void setIdStatusPedido(int idStatusPedido) {
		this.idStatusPedido = idStatusPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdTipoPagamento() {
		return idTipoPagamento;
	}

	public void setIdTipoPagamento(int idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
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

	public int getIdStatusPagamento() {
		return idStatusPagamento;
	}

	public void setIdStatusPagamento(int idStatusPagamento) {
		this.idStatusPagamento = idStatusPagamento;
	}

}