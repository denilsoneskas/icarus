package br.com.icarusxc.icarus.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.icarusxc.icarus.dto.ClubeDto;
import br.com.icarusxc.icarus.entity.Clube;

@Component
public class ClubeBuilder {

	@Autowired
	private CidadeService cidadeService;

	public Clube construirClube(ClubeDto dto) {
		Clube clube = new Clube();
		clube.setNome(dto.getNome());
		clube.setLogradouro(dto.getLogradouro());
		clube.setNumero(dto.getNumero());
		clube.setReferencia(dto.getReferencia());
		clube.setComplemento(dto.getComplemento());
		clube.setBairro(dto.getBairro());
		cidadeService.ler(dto.getCidade()).ifPresent(clube::setCidade);
		
		return clube;
	}

	public Clube construirClubeAtualizado(ClubeDto dto) {
		Clube clube = new Clube();
		clube.setNome(dto.getNome());
		clube.setLogradouro(dto.getLogradouro());
		clube.setNumero(dto.getNumero());
		clube.setReferencia(dto.getReferencia());
		clube.setComplemento(dto.getComplemento());
		clube.setBairro(dto.getBairro());
		cidadeService.ler(dto.getCidade()).ifPresent(clube::setCidade);
		
		return clube;
	}

}
