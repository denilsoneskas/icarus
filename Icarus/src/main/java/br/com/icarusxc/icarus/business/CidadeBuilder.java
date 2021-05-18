package br.com.icarusxc.icarus.business;

import org.springframework.stereotype.Component;

import br.com.icarusxc.icarus.dto.CidadeDto;
import br.com.icarusxc.icarus.entity.Cidade;


@Component
public class CidadeBuilder {

	public Cidade construirCidade(CidadeDto dto) {
		Cidade cidade = new Cidade();
		cidade.setNome(dto.getNome());
		cidade.setCep(dto.getCep());
		cidade.setEstado(dto.getEstado());
		return cidade;
	}

	public Cidade construirCidadeAtualizado(CidadeDto dto) {
		Cidade cidade = new Cidade();
		cidade.setNome(dto.getNome());
		cidade.setCep(dto.getCep());
		cidade.setEstado(dto.getEstado());
		return cidade;
	}

}
