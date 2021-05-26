package br.com.icarusxc.icarus.business;

import org.springframework.stereotype.Component;

import br.com.icarusxc.icarus.dto.FabricanteDto;
import br.com.icarusxc.icarus.entity.Fabricante;


@Component
public class FabricanteBuilder {

	public Fabricante construirFabricante(FabricanteDto dto) {
		Fabricante fabricante = new Fabricante();
		fabricante.setNome(dto.getNome());
		return fabricante;
	}

}
