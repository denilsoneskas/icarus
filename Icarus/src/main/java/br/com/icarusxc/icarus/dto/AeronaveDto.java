package br.com.icarusxc.icarus.dto;

public class AeronaveDto extends BaseDto {

	private Long fabricante;
	
	private String modelo;
	
	private String certificacao;

	public Long getFabricante() {
		return fabricante;
	}

	public void setFabricante(Long fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(String certificacao) {
		this.certificacao = certificacao;
	}

}
