package br.com.icarusxc.icarus.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.icarusxc.icarus.dto.EtapaDto;
import br.com.icarusxc.icarus.entity.Etapa;

@Component
public class EtapaBuilder {

	@Autowired
	private ProvaService provaService;
	
	@Autowired
	private PilotoService pilotoService;

	public Etapa construirEtapa(EtapaDto dto) {
		Etapa etapa = new Etapa();
		provaService.ler(dto.getProva()).ifPresent(etapa::setProva);
		pilotoService.ler(dto.getPiloto()).ifPresent(etapa::setPiloto);
		etapa.setDecolagem(dto.getDecolagem());
		etapa.setPouso(dto.getPouso());
		etapa.setDistanciaMosca(dto.getDistanciaMosca());
		return etapa;
	}

}
