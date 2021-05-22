package br.com.icarusxc.icarus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.icarusxc.icarus.business.EtapaBuilder;
import br.com.icarusxc.icarus.business.EtapaService;
import br.com.icarusxc.icarus.dto.EtapaDto;
import br.com.icarusxc.icarus.entity.Etapa;

@RestController
@RequestMapping("/etapas")
public class EtapaController implements BaseController<EtapaDto, Etapa> {

	private EtapaService service;
	private EtapaBuilder builder;

	public EtapaController(EtapaService service, EtapaBuilder builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public ResponseEntity<Etapa> criar(EtapaDto dto) {
		
//		if (dto.getNome() !=null && dto.getNome() != "") {
//			Optional<Etapa> etapaExiste = service.etapaExiste(dto.getNome());
//			if (!etapaExiste.isPresent()) {
//				Etapa etapa = service.criar(builder.construirEtapa(dto));
//				return new ResponseEntity<Etapa>(etapa, HttpStatus.CREATED);
//			}
//		}
//		return new ResponseEntity<Etapa>(HttpStatus.OK);

		Etapa etapa = service.criar(builder.construirEtapa(dto));
		return new ResponseEntity<Etapa>(etapa, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Etapa> ler(Long id) {
		Optional<Etapa> etapa = service.ler(id);
		if (etapa.isPresent()) {
			return new ResponseEntity<Etapa>(etapa.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Etapa>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Etapa> lerTudo() {
		return service.lerTudo();
	}

	@Override
	public ResponseEntity<Void> atualizar(Long id, EtapaDto dto) {
		Optional<Etapa> etapaStored = service.ler(id);
		if (etapaStored.isPresent()) {
			Etapa etapa = builder.construirEtapaAtualizado(dto);
			service.atualizar(id, etapa);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Void> deletar(Long id) {
		Optional<Etapa> etapaStored = service.ler(id);
		if (etapaStored.isPresent()) {
			service.deletar(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
