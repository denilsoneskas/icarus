package br.com.icarusxc.icarus.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.icarusxc.icarus.dto.PilotoDto;
import br.com.icarusxc.icarus.entity.Piloto;

@Component
public class PilotoBuilder {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private AeronaveService aeronaveService;
	
	@Autowired
	private ClubeService clubeService;

	public Piloto construirPiloto(PilotoDto dto) {
		Piloto piloto = new Piloto();
		piloto.setNome(dto.getNome());
		piloto.setDataNascimento(dto.getDataNascimento());

		enderecoService.ler(dto.getEndereco()).ifPresent(piloto::setEndereco);
		aeronaveService.ler(dto.getAeronave()).ifPresent(piloto::setAeronave);
		clubeService.ler(dto.getClube()).ifPresent(piloto::setClube);

		return piloto;
	}

	public Piloto construirPilotoAtualizado(PilotoDto dto) {
		Piloto piloto = new Piloto();
		piloto.setNome(dto.getNome());
		piloto.setDataNascimento(dto.getDataNascimento());
		
		enderecoService.ler(dto.getEndereco()).ifPresent(piloto::setEndereco);
		aeronaveService.ler(dto.getAeronave()).ifPresent(piloto::setAeronave);
		clubeService.ler(dto.getClube()).ifPresent(piloto::setClube);
		
		return piloto;
	}

}
