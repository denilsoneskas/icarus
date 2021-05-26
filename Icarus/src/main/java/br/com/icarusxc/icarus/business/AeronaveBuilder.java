package br.com.icarusxc.icarus.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.icarusxc.icarus.dto.AeronaveDto;
import br.com.icarusxc.icarus.entity.Aeronave;
import br.com.icarusxc.icarus.entity.Fabricante;

@Component
public class AeronaveBuilder {

	@Autowired
	private FabricanteService fabricanteService;

	public Aeronave construirAeronave(AeronaveDto dto) {
		Aeronave aeronave = new Aeronave();
		Optional<Fabricante> fabricanteopOptional = fabricanteService.ler(dto.getFabricante());
		if(fabricanteopOptional.isPresent()) {
			Fabricante fabricante = fabricanteopOptional.get();
			aeronave.setFabricante(fabricante);
		}
		aeronave.setModelo(dto.getModelo());
		aeronave.setCertificacao(dto.getCertificacao());
		return aeronave;
	}

}
