package br.com.icarusxc.icarus.dto;

import java.sql.Date;

public class ProvaDto extends BaseDto {
	
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
