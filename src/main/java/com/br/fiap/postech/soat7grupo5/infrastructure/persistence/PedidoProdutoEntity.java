package com.br.fiap.postech.soat7grupo5.infrastructure.persistence;

import com.br.fiap.postech.soat7grupo5.domain.entity.PedidoProduto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class PedidoProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPedidoProduto;
	private int idPedido;
	private int idProduto;
    private Double precoProduto;
    private String nomeProduto;
    private int duracaoPreparo;
    
    public PedidoProdutoEntity(int idPedidoProduto, int idPedido, int idProduto, String nomeProduto, Double precoProduto, int duracaoPreparo) {
    	this.idPedidoProduto = idPedidoProduto;
    	this.idPedido = idPedido;
    	this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		this.duracaoPreparo = duracaoPreparo;
    }
    
    public PedidoProdutoEntity(PedidoProduto pedidoProduto) {
    	this.idPedidoProduto = pedidoProduto.getIdPedidoProduto();
    	this.idPedido = pedidoProduto.getIdPedido();
    	this.idProduto = pedidoProduto.getIdProduto();
		this.nomeProduto = pedidoProduto.getNomeProduto();
		this.precoProduto = pedidoProduto.getPrecoProduto();
		this.duracaoPreparo = pedidoProduto.getDuracaoPreparo();
	}
    
    public PedidoProdutoEntity() {
		// TODO Auto-generated constructor stub
	}
    
    public PedidoProduto toPedidoProduto() {
        return new PedidoProduto(this.idPedidoProduto, this.idPedido, this.idProduto, this.nomeProduto, this.precoProduto, this.duracaoPreparo);
    }

//	public void atualizar(PedidoProduto pedidoProduto) {
//		this.idPedidoProduto = pedidoProduto.getIdPedidoProduto();
//		this.idPedido = pedidoProduto.getIdPedido();
//		this.idProduto = pedidoProduto.getIdProduto();
//		this.nomeProduto = Objects.nonNull(pedidoProduto.getNomeProduto()) ? pedidoProduto.getNomeProduto() : this.nomeProduto;
//		this.precoProduto = Objects.nonNull(pedidoProduto.getPrecoProduto()) ? pedidoProduto.getPrecoProduto() : this.precoProduto;
//		this.duracaoPreparo = (pedidoProduto.getDuracaoPreparo() != 0) ? pedidoProduto.getDuracaoPreparo() : this.duracaoPreparo;
//	}
}
