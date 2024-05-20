package com.br.fiap.postech.soat7grupo5.infra.adapters.entities;

import java.util.Objects;

import com.br.fiap.postech.soat7grupo5.domain.Produto;

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
	}

	public ProdutoEntity(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.duracaoPreparo = produto.getDuracaoPreparo();
		this.idTipo = produto.getIdTipo();
		this.flAtivo = produto.getFlAtivo();
	}

	public void atualizar(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nome = Objects.nonNull(produto.getNome()) ? produto.getNome() : this.nome;
		this.descricao = Objects.nonNull(produto.getDescricao()) ? produto.getDescricao() : this.descricao;
		this.preco = Objects.nonNull(produto.getPreco()) ? produto.getPreco() : this.preco;
		this.duracaoPreparo = (produto.getDuracaoPreparo() != 0) ? produto.getDuracaoPreparo() : this.duracaoPreparo;
		this.idTipo = (produto.getIdTipo() != 0) ? produto.getIdTipo() : this.idTipo;
		this.flAtivo = (produto.getFlAtivo() != 0) ? produto.getFlAtivo() : flAtivo;
	}

	public void desativar() {
		this.flAtivo = 0;
	}
	
	public Produto toProduto() {
		return new Produto(this.idProduto, this.nome, this.descricao, this.preco, this.duracaoPreparo, this.idTipo, this.flAtivo);
	}
}