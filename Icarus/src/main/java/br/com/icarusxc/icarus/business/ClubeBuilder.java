package br.com.icarusxc.icarus.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.icarusxc.icarus.dto.ClubeDto;
import br.com.icarusxc.icarus.entity.Clube;

@Component
public class ClubeBuilder {

	@Autowired
	private EnderecoService enderecoService;

	public Clube construirClube(ClubeDto dto) {
		Clube clube = new Clube();
		clube.setNome(dto.getNome());
		enderecoService.ler(dto.getEndereco()).ifPresent(clube::setEndereco);
		
		return clube;
	}

	public Clube construirClubeAtualizado(ClubeDto dto) {
		Clube clube = new Clube();
		clube.setNome(dto.getNome());
		enderecoService.ler(dto.getEndereco()).ifPresent(clube::setEndereco);
		
		return clube;
	}

}
