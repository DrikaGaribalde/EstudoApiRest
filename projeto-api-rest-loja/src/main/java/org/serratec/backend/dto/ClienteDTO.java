package org.serratec.backend.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.serratec.backend.entity.PedidoEntity;

public class ClienteDTO {

	@Email
	private String email;

	@Size(min = 3, max = 50) // verificar quantidade de caracteres
	private String username;

	private String senha;

	@Size(min = 3, max = 50)
	private String nome;
	private String cpf;
	private String telefone;

	@Past
	@Column(name = "dtNascimento")
	private LocalDate dtNascimento;

	private String token;

	private List<EnderecoDTO> endereco = new ArrayList<EnderecoDTO>();

	private List<PedidoDTO> pedidos = new ArrayList<PedidoDTO>();

	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<EnderecoDTO> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoDTO> endereco) {

		this.endereco.addAll(endereco);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cPF) {
		cpf = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

}
