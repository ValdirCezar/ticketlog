package com.ticketlog.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer populacao;
	private Double custoCidadeUS;

	private Double custoPorCidadaoAoEstado = 123.45; // Valor em Dollar americano

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	public Cidade() {
		super();
	}

	public Cidade(Integer id, String nome, Integer populacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}

	public Double getCustoCidadeUS() {
		return custoCidadeUS;
	}

	public void setCustoCidadeUS(Double custoCidadeUS) {
		this.custoCidadeUS = custoCidadeUS;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Double getCustoPorCidadaoAoEstado() {
		return custoPorCidadaoAoEstado;
	}

	public void setCustoPorCidadaoAoEstado(Double custoPorCidadaoAoEstado) {
		this.custoPorCidadaoAoEstado = custoPorCidadaoAoEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
