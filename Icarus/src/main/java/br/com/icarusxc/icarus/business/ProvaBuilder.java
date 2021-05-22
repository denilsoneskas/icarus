package br.com.icarusxc.icarus.business;

import org.springframework.stereotype.Component;

import br.com.icarusxc.icarus.dto.ProvaDto;
import br.com.icarusxc.icarus.entity.Prova;

@Component
public class ProvaBuilder {

	public Prova construirProva(ProvaDto dto) {
		Prova prova = new Prova();
		prova.setNome(dto.getNome());
		prova.setDataProva(dto.getDataProva());
		return prova;
	}

	public Prova construirProvaAtualizado(ProvaDto dto) {
		Prova prova = new Prova();
		prova.setNome(dto.getNome());
		prova.setDataProva(dto.getDataProva());
		return prova;
	}

}
