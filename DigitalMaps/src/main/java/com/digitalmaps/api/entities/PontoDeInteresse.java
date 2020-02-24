package com.digitalmaps.api.entities;

import java.beans.Transient;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "ponto_interesse")
public class PontoDeInteresse {

	private long id;
	private String nome;
	private int coordenadaX;	
	private int coordenadaY;
	private Time opened;
	private Time closed;
	private String statusFuncionamento;	

	public PontoDeInteresse() {		
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}		
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Range(min=0)
	@Column(name = "coordenadaX", nullable = false)
	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	@Column(name = "coordenadaY", nullable = false)
	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	@Column(name = "opened", nullable = true)
	public Time getOpened() {
		return opened;
	}
	
	public void setOpened(Time opened) {
		this.opened = opened;
	}

	@Column(name = "closed", nullable = true)
	public Time getClosed() {
		return closed;
	}

	public void setClosed(Time closed) {
		this.closed = closed;
	}
	
	@Transient	
	public String getStatusFuncionamento() {
		return statusFuncionamento;
	}

	public void setStatusFuncionamento(String statusFuncionamento) {
		this.statusFuncionamento = statusFuncionamento;
	}
}
