package br.com.icarusxc.icarus.dto;

public class ClubeDto extends BaseDto {

	private String nome;

	private Long endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getEndereco() {
		return endereco;
	}

	public void setEndereco(Long endereco) {
		this.endereco = endereco;
	}


}
