package com.br.fiap.postech.soat7grupo5.domain.entity;

//public record PedidoProduto (int idPedidoProduto, int idPedido, int idProduto, String nomeProduto, Double precoProduto, int duracaoPreparo){
public class PedidoProduto {
	
	private int idPedidoProduto;
	private int idPedido;
	private int idProduto;
    private Double precoProduto;
    private String nomeProduto;
    private int duracaoPreparo;
    
    public PedidoProduto() {
		// TODO Auto-generated constructor stub
	}

	public PedidoProduto(int idPedidoProduto, int idPedido, int idProduto, String nomeProduto, Double precoProduto,	int duracaoPreparo) {
		this.idPedidoProduto= idPedidoProduto;
		this.idPedido = idPedido;
		this.idProduto = idProduto;
	    this.precoProduto = precoProduto;
	    this.nomeProduto = nomeProduto;
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
}
