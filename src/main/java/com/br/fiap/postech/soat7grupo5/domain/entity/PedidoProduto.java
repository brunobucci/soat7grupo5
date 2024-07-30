package com.br.fiap.postech.soat7grupo5.domain.entity;

public class PedidoProduto {

	private int idPedidoProduto;
	private int idPedido;
	private int idProduto;
    private Double precoProduto;
    private String nomeProduto;
    private int duracaoPreparo;
    
    public PedidoProduto(int idPedidoProduto2, int idPedido2, int idProduto2, String nomeProduto2, Double precoProduto2, int duracaoPreparo2) {
		// TODO Auto-generated constructor stub
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
}
