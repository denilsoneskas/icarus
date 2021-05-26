package br.com.icarusxc.icarus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.icarusxc.icarus.business.PilotoBuilder;
import br.com.icarusxc.icarus.business.PilotoService;
import br.com.icarusxc.icarus.dto.PilotoDto;
import br.com.icarusxc.icarus.entity.Piloto;

@RestController
@RequestMapping("/pilotos")
public class PilotoController implements BaseController<PilotoDto, Piloto> {

	private PilotoService service;
	private PilotoBuilder builder;

	public PilotoController(PilotoService service, PilotoBuilder builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public ResponseEntity<Piloto> criar(PilotoDto dto) {
		
		if (dto.getNome() !=null && dto.getNome() != "") {
			Optional<Piloto> pilotoExiste = service.pilotoExiste(dto.getNome());
			if (!pilotoExiste.isPresent()) {
				Piloto piloto = service.criar(builder.construirPiloto(dto));
				return new ResponseEntity<Piloto>(piloto, HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Piloto>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Piloto> ler(Long id) {
		Optional<Piloto> piloto = service.ler(id);
		if (piloto.isPresent()) {
			return new ResponseEntity<Piloto>(piloto.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Piloto>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Piloto> lerTudo() {
		return service.lerTudo();
	}

	@Override
	public ResponseEntity<Void> atualizar(Long id, PilotoDto dto) {
		Optional<Piloto> pilotoStored = service.ler(id);
		if (pilotoStored.isPresent()) {
			Piloto piloto = builder.construirPiloto(dto);
			service.atualizar(id, piloto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Void> deletar(Long id) {
		Optional<Piloto> pilotoStored = service.ler(id);
		if (pilotoStored.isPresent()) {
			service.deletar(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
