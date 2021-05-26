package br.com.icarusxc.icarus.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Etapa extends BaseEntity {

	private Prova prova;
	
	private Piloto piloto;
	
	private LocalDateTime decolagem;
	
	private LocalDateTime pouso;
	
	private LocalTime permanencia;
	
	private double distanciaMosca;

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
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

	public void decolar() {
		this.setDecolagem(LocalDateTime.now());		
	}
	
	public void pousar() {
		this.setPouso(LocalDateTime.now());		
	}

	public LocalTime getPermanencia() {
		return permanencia;
	}

	public void setPermanencia(LocalTime permanencia) {
		this.permanencia = permanencia;
	}
	
}
