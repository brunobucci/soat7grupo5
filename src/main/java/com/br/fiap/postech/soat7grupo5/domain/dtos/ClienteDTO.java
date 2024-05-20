package com.br.fiap.postech.soat7grupo5.domain.dtos;

public class ClienteDTO {

	private int idCliente;
	private String cpf;
	private String nome;
	private String email;
	private int idCampanha;
	
	public ClienteDTO(int idCliente, String cpf, String nome, String email, int idCampanha) {
		super();
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.idCampanha = idCampanha;
	}

	public int getIdCliente() {
		return idCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public int getIdCampanha() {
		return idCampanha;
	}
}
