package br.com.icarusxc.icarus.entity;

public class Cidade extends BaseEntity {
	
	private String nome;
	
	private String estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
