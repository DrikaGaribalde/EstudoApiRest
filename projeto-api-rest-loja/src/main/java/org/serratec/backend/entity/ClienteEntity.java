package org.serratec.backend.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotNull
	@Email
	private String email;
	
//	@Lob
	@Size(min = 3, max = 50) 
	@NotNull
	private String username;

//	@Size(min = 3, max = 40) // deve usar MD5 no banco
	@NotNull
	private String senha;

	@NotNull
	@Size(min = 3, max = 50)
	private String nome;

	@NotNull
	@CPF
	private String cpf;

	@NotNull
	@Size(min = 8, max = 11)
	private String telefone; //verificar máscara
	private String token;
	
	private boolean habilitado = true;

	@Past
	@Column(name = "dtNascimento")
	private LocalDate dtNascimento;
	
//	private LocalDateTime horaDoToken;
	
	// associações entre a classe Endereco
	@OneToMany(mappedBy = "cliente", cascade= CascadeType.ALL)
	private List<EnderecoEntity> endereco = new ArrayList<EnderecoEntity>();
	
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)//fetch = FetchType.LAZY
	private List<PedidoEntity> pedidos = new ArrayList<PedidoEntity>();
	
	public List<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(PedidoEntity pedidos) {
		this.pedidos.add(pedidos);
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

//	public LocalDateTime getHoraDoToken() {
//		return horaDoToken;
//	}

//	public void setHoraDoToken(LocalDateTime horaDoToken) {
//		this.horaDoToken = horaDoToken;
//	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	//
	public void setEndereco(List<EnderecoEntity> endereco) {
		this.endereco = endereco;
	}

	public List<EnderecoEntity> getEndereco() {
		return endereco;
	}

	//
//
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
