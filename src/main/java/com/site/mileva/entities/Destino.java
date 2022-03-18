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
public class Destino implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_destino;
	private String CidadeDestino;
	
	@JsonIgnore
	@OneToMany(mappedBy = "destino")
	private List<Viagem> viagens = new ArrayList<Viagem>();

	public Destino() {
		super();
	}

	public Destino(Long id_destino, String cidadeDestino) {
		super();
		this.Id_destino = id_destino;
		this.CidadeDestino = cidadeDestino;
	}

	public Long getId_destino() {
		return Id_destino;
	}

	public void setId_destino(Long id_destino) {
		Id_destino = id_destino;
	}

	public String getCidadeDestino() {
		return CidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		CidadeDestino = cidadeDestino;
	}
	
	public List<Viagem> getViagens() {
		return viagens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_destino);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destino other = (Destino) obj;
		return Objects.equals(Id_destino, other.Id_destino);
	}

	
	


}
