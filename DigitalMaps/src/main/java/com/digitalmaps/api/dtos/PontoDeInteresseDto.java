package com.digitalmaps.api.dtos;

import java.io.Serializable;
import java.sql.Time;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PontoDeInteresseDto implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;

	private long id;
	private String nome;	
	private int coordenadaX;	
	private int coordenadaY;
	private Time opened = null;;
	private Time closed = null;
	private String statusFuncionamento;		

	public PontoDeInteresseDto() {
		super();
	}

	public PontoDeInteresseDto(long id, String nome, int coordenadaX, int coordenadaY, Time opened, Time closed,
			String statusFuncionamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.opened = opened;
		this.closed = closed;
		this.statusFuncionamento = statusFuncionamento;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty("nome")
	@NotEmpty(message = "Nome é obrigatorio.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

	@JsonProperty("cordenadaX")
	@Min(value = 0L, message = "Cordenada x não pode ser negativa.")
	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	@JsonProperty("cordenadaY")
	@Min(value = 0L, message = "Cordenada y não pode ser negativa.")
	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	@JsonFormat(pattern="HH:mm:ss")
	@JsonProperty("opened")
	public Time getOpened() {
		return opened;
	}

	public void setOpened(Time opened) {
		this.opened = opened;
	}

	@JsonFormat(pattern="HH:mm:ss")
	@JsonProperty("closed")
	public Time getClosed() {
		return closed;
	}

	public void setClosed(Time closed) {
		this.closed = closed;
	}
	
	public String getStatusFuncionamento() {
		return statusFuncionamento;
	}

	@JsonProperty("statusFuncionamento")
	public void setStatusFuncionamento(String statusFuncionamento) {
		this.statusFuncionamento = statusFuncionamento;
	}
}
