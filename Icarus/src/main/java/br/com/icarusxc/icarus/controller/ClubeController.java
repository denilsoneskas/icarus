package br.com.icarusxc.icarus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.icarusxc.icarus.business.ClubeBuilder;
import br.com.icarusxc.icarus.business.ClubeService;
import br.com.icarusxc.icarus.dto.ClubeDto;
import br.com.icarusxc.icarus.entity.Clube;

@RestController
@RequestMapping("/clubes")
public class ClubeController implements BaseController<ClubeDto, Clube> {

	private ClubeService service;
	private ClubeBuilder builder;

	public ClubeController(ClubeService service, ClubeBuilder builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public ResponseEntity<Clube> criar(ClubeDto clubeDto) {
		
		if (clubeDto.getNome() !=null && clubeDto.getNome() != "") {
			Optional<Clube> clubeExiste = service.clubeExiste(clubeDto.getNome());
			if (!clubeExiste.isPresent()) {
				Clube clube = service.criar(builder.construirClube(clubeDto));
				return new ResponseEntity<Clube>(clube, HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Clube>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Clube> ler(Long id) {
		Optional<Clube> clube = service.ler(id);
		if (clube.isPresent()) {
			return new ResponseEntity<Clube>(clube.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Clube>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Clube> lerTudo() {
		return service.lerTudo();
	}

	@Override
	public ResponseEntity<Void> atualizar(Long id, ClubeDto dto) {
		Optional<Clube> clubeStored = service.ler(id);
		if (clubeStored.isPresent()) {
			Clube clube = builder.construirClubeAtualizado(dto);
			service.atualizar(id, clube);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Void> deletar(Long id) {
		Optional<Clube> clubeStored = service.ler(id);
		if (clubeStored.isPresent()) {
			service.deletar(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
