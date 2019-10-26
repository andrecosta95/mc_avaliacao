package com.fiap.avaliacoes.api.model;

import javax.persistence.*;

@Entity
@Table(name="avaliacoes")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idavaliacoes;

	private String filme;

	private int nota;

	public int getIdavaliacoes() {
		return idavaliacoes;
	}

	public void setIdavaliacoes(int idavaliacoes) {
		this.idavaliacoes = idavaliacoes;
	}

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}