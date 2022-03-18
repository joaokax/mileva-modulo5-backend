package com.site.mileva.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_usuario;
	private String nome;
	private int idade;
	private String email;
	private String telefone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Viagem> viagens = new ArrayList<Viagem>();

	public Usuario() {
		super();
	}

	public Usuario(Long id_usuario, String nome, int idade, String email, String telefone) {
		super();
		this.Id_usuario = id_usuario;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId_usuario() {
		return Id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		Id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Viagem> getViagens() {
		return viagens;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(Id_usuario, other.Id_usuario);
	}
	

}
