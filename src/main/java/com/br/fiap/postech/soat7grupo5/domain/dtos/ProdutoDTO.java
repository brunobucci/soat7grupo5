package com.br.fiap.postech.soat7grupo5.domain.dtos;

public class ProdutoDTO {
	private int idProduto;
    private String nome;
    private String descricao;
    private Double preco;
    private int duracaoPreparo;
    private int idTipo;
    private int flAtivo;

    public ProdutoDTO(int idProduto, String nome, String descricao, Double preco, int duracaoPreparo, int idTipo, int flAtivo) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.duracaoPreparo = duracaoPreparo;
		this.idTipo = idTipo;
		this.flAtivo = flAtivo;
	}

    public ProdutoDTO() {
	}

	public int getIdProduto() {
		return idProduto;
	}
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getPreco() {
		return preco;
	}
	public int getDuracaoPreparo() {
		return duracaoPreparo;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public int getFlAtivo() {
		return flAtivo;
	}

}