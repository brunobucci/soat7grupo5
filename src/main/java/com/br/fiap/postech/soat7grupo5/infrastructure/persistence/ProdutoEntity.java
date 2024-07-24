package com.br.fiap.postech.soat7grupo5.infrastructure.persistence;


import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduto;
	private String nome;
	private String descricao;
	private Double preco;
	private int duracaoPreparo;
	private int idTipo;
	private int flAtivo;

	
	public ProdutoEntity() {
		// TODO Auto-generated constructor stub
	}


	public ProdutoEntity(int idProduto, String nome, String descricao, Double preco, int duracaoPreparo, int idTipo, int flAtivo) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.duracaoPreparo = duracaoPreparo;
		this.idTipo = idTipo;
		this.flAtivo = flAtivo;
	}


	public void desativar() {
		this.flAtivo = 0;
	}
	
	public Produto toProduto() {
		return new Produto(this.idProduto, this.nome, this.descricao, this.preco, this.duracaoPreparo, this.idTipo, this.flAtivo);
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


	public int getFlAtivo() {
		return flAtivo;
	}


	public void setFlAtivo(int flAtivo) {
		this.flAtivo = flAtivo;
	}
	
}
