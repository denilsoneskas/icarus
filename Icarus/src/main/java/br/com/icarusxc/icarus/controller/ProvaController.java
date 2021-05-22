package br.com.icarusxc.icarus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.icarusxc.icarus.business.ProvaBuilder;
import br.com.icarusxc.icarus.business.ProvaService;
import br.com.icarusxc.icarus.dto.ProvaDto;
import br.com.icarusxc.icarus.entity.Prova;

@RestController
@RequestMapping("/provas")
public class ProvaController implements BaseController<ProvaDto, Prova> {

	private ProvaService service;
	private ProvaBuilder builder;

	public ProvaController(ProvaService service, ProvaBuilder builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public ResponseEntity<Prova> criar(ProvaDto provaDto) {
		
		if (provaDto.getNome() !=null && provaDto.getNome() != "") {
			Optional<Prova> provaExiste = service.provaExiste(provaDto.getNome());
			if (!provaExiste.isPresent()) {
				Prova prova = service.criar(builder.construirProva(provaDto));
				return new ResponseEntity<Prova>(prova, HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Prova>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Prova> ler(Long id) {
		Optional<Prova> prova = service.ler(id);
		if (prova.isPresent()) {
			return new ResponseEntity<Prova>(prova.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Prova>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Prova> lerTudo() {
		return service.lerTudo();
	}

	@Override
	public ResponseEntity<Void> atualizar(Long id, ProvaDto dto) {
		Optional<Prova> provaStored = service.ler(id);
		if (provaStored.isPresent()) {
			Prova prova = builder.construirProvaAtualizado(dto);
			service.atualizar(id, prova);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Void> deletar(Long id) {
		Optional<Prova> provaStored = service.ler(id);
		if (provaStored.isPresent()) {
			service.deletar(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
