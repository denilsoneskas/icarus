package br.com.icarusxc.icarus.dto;

import java.time.LocalDateTime;

public class EtapaDto extends BaseDto {
	
	private Long prova;

	private Long piloto;
	
	private LocalDateTime decolagem;
	
	private LocalDateTime pouso;
	
	private double distanciaMosca;

	public Long getProva() {
		return prova;
	}

	public void setProva(Long prova) {
		this.prova = prova;
	}

	public Long getPiloto() {
		return piloto;
	}

	public void setPiloto(Long piloto) {
		this.piloto = piloto;
	}

	public LocalDateTime getDecolagem() {
		return decolagem;
	}

	public void setDecolagem(LocalDateTime decolagem) {
		this.decolagem = decolagem;
	}

	public LocalDateTime getPouso() {
		return pouso;
	}

	public void setPouso(LocalDateTime pouso) {
		this.pouso = pouso;
	}

	public double getDistanciaMosca() {
		return distanciaMosca;
	}

	public void setDistanciaMosca(double distanciaMosca) {
		this.distanciaMosca = distanciaMosca;
	}

}
