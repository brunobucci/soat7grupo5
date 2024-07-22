package com.br.fiap.postech.soat7grupo5.domain;

import com.br.fiap.postech.soat7grupo5.domain.dtos.ProdutoDTO;

public class Produto {

    private int idProduto;
    private String nome;
    private String descricao;
    private Double preco;
    private int duracaoPreparo;
    private int idTipo;
    private int flAtivo;

    public Produto(int idProduto, String nome, String descricao, Double preco, int duracaoPreparo, int idTipo, int flAtivo) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.duracaoPreparo = duracaoPreparo;
		this.idTipo = idTipo;
		this.flAtivo = flAtivo;
	}

    public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getDuracaoPreparo() {
		return duracaoPreparo;
	}

	public void setDuracaoPreparo(int duracaoPreparo) {
		this.duracaoPreparo = duracaoPreparo;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	public void setFlAtivo(int flAtivo) {
		this.flAtivo = flAtivo;
	}
	
	public int getFlAtivo() {
		return flAtivo;
	}

	public Produto(ProdutoDTO produtoDTO) {
		this.idProduto = produtoDTO.getIdProduto();
		this.nome = produtoDTO.getNome();
		this.descricao = produtoDTO.getDescricao();
		this.preco = produtoDTO.getPreco();
		this.duracaoPreparo = produtoDTO.getDuracaoPreparo();
		this.idTipo = produtoDTO.getIdTipo();
		this.flAtivo = produtoDTO.getFlAtivo();
    }

	public ProdutoDTO toProdutoDTO() {
        return new ProdutoDTO(this.idProduto, this.nome, this.descricao, this.preco, this.duracaoPreparo, this.idTipo, this.flAtivo);
    }

}