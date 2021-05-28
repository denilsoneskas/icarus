package br.com.icarusxc.icarus.dto;

import java.sql.Date;

public class PilotoDto extends BaseDto {
	
	private int codigo;

	private String nome;
	
	private Date dataNascimento;
	
	private Long endereco;
	
	private Long aeronave;
	
	private Long clube;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getEndereco() {
		return endereco;
	}

	public void setEndereco(Long endereco) {
		this.endereco = endereco;
	}

	public Long getAeronave() {
		return aeronave;
	}

	public void setAeronave(Long aeronave) {
		this.aeronave = aeronave;
	}

	public Long getClube() {
		return clube;
	}

	public void setClube(Long clube) {
		this.clube = clube;
	}
	
}
