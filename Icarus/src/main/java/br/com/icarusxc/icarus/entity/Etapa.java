package br.com.icarusxc.icarus.entity;

import java.sql.Date;

public class Etapa extends BaseEntity {

	private Prova prova;
	
	private Piloto piloto;
	
	private Date decolagem;
	
	private Date pouso;
	
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
