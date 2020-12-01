package com.ticketlog.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ticketlog.domain.Estado;

public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message = "Campo Obrigatório")
	@Size(min = 2, max = 80, message = "Tamanho mínimo é 2 cracteres e máximo 80 caracteres")
	private String nome;
	
	@NotBlank(message = "Campo Obrigatório")
	private Integer populacao;
	private Double custoEstadoUS;

	public EstadoDTO() {
		super();
	}

	public EstadoDTO(Estado obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.populacao = obj.getPopulacao();
		this.custoEstadoUS = obj.getCustoEstadoUS();
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

	public Double getCustoEstadoUS() {
		return custoEstadoUS;
	}

	public void setCustoEstadoUS(Double custoEstadoUS) {
		this.custoEstadoUS = custoEstadoUS;
	}

}
