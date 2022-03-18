package com.site.mileva.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Viagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_viagem;
	private String AeroportoPartida;
	private String AeroportoChegada;
	private String DataIda;
	private String DataVolta;
	private double Valor;
	
	@ManyToOne
	@JoinColumn(name = "Usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "Destino_id")
	private Destino destino;

	public Viagem() {
		super();
	}

	public Viagem(Long id_viagem, String aeroportoPartida, String aeroportoChegada, String dataIda, String dataVolta,
			double valor, Usuario usuario, Destino destino) {
		super();
		this.Id_viagem = id_viagem;
		this.AeroportoPartida = aeroportoPartida;
		this.AeroportoChegada = aeroportoChegada;
		this.DataIda = dataIda;
		this.DataVolta = dataVolta;
		this.Valor = valor;
		this.usuario = usuario;
		this.destino = destino;
	}

	public Long getId_viagem() {
		return Id_viagem;
	}

	public void setId_viagem(Long id_viagem) {
		Id_viagem = id_viagem;
	}

	public String getAeroportoPartida() {
		return AeroportoPartida;
	}

	public void setAeroportoPartida(String aeroportoPartida) {
		AeroportoPartida = aeroportoPartida;
	}

	public String getAeroportoChegada() {
		return AeroportoChegada;
	}

	public void setAeroportoChegada(String aeroportoChegada) {
		AeroportoChegada = aeroportoChegada;
	}

	public String getDataIda() {
		return DataIda;
	}

	public void setDataIda(String dataIda) {
		DataIda = dataIda;
	}

	public String getDataVolta() {
		return DataVolta;
	}

	public void setDataVolta(String dataVolta) {
		DataVolta = dataVolta;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_viagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viagem other = (Viagem) obj;
		return Objects.equals(Id_viagem, other.Id_viagem);
	}

	
}
