package com.br.fiap.postech.soat7grupo5.infrastructure.persistence;

import com.br.fiap.postech.soat7grupo5.domain.entity.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	private String cpf;
	private String nome;
	private String email;
	private int idCampanha;

	public ClienteEntity(int idCliente, String nome, String cpf, String email, int idCampanha) {
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.idCampanha = idCampanha;
	}

	public ClienteEntity() {
		
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdCampanha() {
		return idCampanha;
	}

	public void setIdCampanha(int idCampanha) {
		this.idCampanha = idCampanha;
	}
	
	public Cliente toCliente() {
		return new Cliente(this.idCliente, this.cpf, this.nome, this.email, this.idCampanha);
	}
	
}
