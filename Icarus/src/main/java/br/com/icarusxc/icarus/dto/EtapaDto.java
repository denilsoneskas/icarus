package br.com.icarusxc.icarus.dto;

import java.sql.Date;

public class EtapaDto extends BaseDto {
	
	private Long prova;

	private Long piloto;
	
	private Date decolagem;
	
	private Date pouso;
	
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

	public Date getDecolagem() {
		return decolagem;
	}

	public void setDecolagem(Date decolagem) {
		this.decolagem = decolagem;
	}

	public Date getPouso() {
		return pouso;
	}

	public void setPouso(Date pouso) {
		this.pouso = pouso;
	}

	public double getDistanciaMosca() {
		return distanciaMosca;
	}

	public void setDistanciaMosca(double distanciaMosca) {
		this.distanciaMosca = distanciaMosca;
	}

}
