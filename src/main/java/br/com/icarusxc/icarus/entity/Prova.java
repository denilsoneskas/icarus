package br.com.icarusxc.icarus.entity;

import java.sql.Date;

public class Prova extends BaseEntity {

	private String nome;
	
	private Date dataProva;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataProva() {
		return dataProva;
	}

	public void setDataProva(Date dataProva) {
		this.dataProva = dataProva;
	}
	
}
