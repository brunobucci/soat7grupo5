package com.br.fiap.postech.soat7grupo5.domain;

import com.br.fiap.postech.soat7grupo5.domain.dtos.ClienteDTO;

public class Cliente {

	private int idCliente;
	private String cpf;
	private String nome;
	private String email;
	private int idCampanha;
	
	public Cliente(int idCliente, String cpf, String nome, String email, int idCampanha) {
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.idCampanha = idCampanha;
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
	
	public Cliente(ClienteDTO clienteDTO) {
		this.idCliente = clienteDTO.getIdCliente();
		this.cpf = clienteDTO.getCpf();
		this.nome = clienteDTO.getNome();
		this.email = clienteDTO.getEmail();
		this.idCampanha = clienteDTO.getIdCampanha();
    }

    public ClienteDTO toClienteDTO() {
        return new ClienteDTO(this.idCliente, this.cpf, this.nome, this.email, this.idCampanha);
    }
}
