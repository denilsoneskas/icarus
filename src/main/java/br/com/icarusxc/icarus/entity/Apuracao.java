package br.com.icarusxc.icarus.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.icarusxc.icarus.dto.BaseDto;

public class Apuracao extends BaseDto {
		
	private String pilotoNome;
	
	private String aeronaveModelo;
	
	private String fabricanteNome;
	
	private String clubeNome;
	
	private LocalDateTime decolagem;
	
	private LocalDateTime pouso;
	
	private LocalTime permanencia;
	
	private double distanciaMosca;

	public String getPilotoNome() {
		return pilotoNome;
	}

	public void setPilotoNome(String pilotoNome) {
		this.pilotoNome = pilotoNome;
	}

	public String getAeronaveModelo() {
		return aeronaveModelo;
	}

	public void setAeronaveModelo(String aeronaveModelo) {
		this.aeronaveModelo = aeronaveModelo;
	}

	public String getFabricanteNome() {
		return fabricanteNome;
	}

	public void setFabricanteNome(String fabricanteNome) {
		this.fabricanteNome = fabricanteNome;
	}

	public String getClubeNome() {
		return clubeNome;
	}

	public void setClubeNome(String clubeNome) {
		this.clubeNome = clubeNome;
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

	public LocalTime getPermanencia() {
		return permanencia;
	}

	public void setPermanencia(LocalTime permanencia) {
		this.permanencia = permanencia;
	}

	public double getDistanciaMosca() {
		return distanciaMosca;
	}

	public void setDistanciaMosca(double distanciaMosca) {
		this.distanciaMosca = distanciaMosca;
	}

}
