package com.br.fiap.postech.soat7grupo5.infra.adapters.entities;

import com.br.fiap.postech.soat7grupo5.domain.Cliente;

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

	public ClienteEntity() {
	}

	public ClienteEntity(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.idCampanha = cliente.getIdCampanha();
	}

	public void atualizar(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.idCampanha = cliente.getIdCampanha();
	}
	
	public Cliente toCliente() {
		return new Cliente(this.idCliente, this.cpf, this.nome, this.email, this.idCampanha);
	}

}
