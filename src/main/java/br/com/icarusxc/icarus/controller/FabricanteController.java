package br.com.icarusxc.icarus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.icarusxc.icarus.business.FabricanteBuilder;
import br.com.icarusxc.icarus.business.FabricanteService;
import br.com.icarusxc.icarus.dto.FabricanteDto;
import br.com.icarusxc.icarus.entity.Fabricante;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController implements BaseController<FabricanteDto, Fabricante> {

	private FabricanteService service;
	private FabricanteBuilder builder;
	
	public FabricanteController(FabricanteService service, FabricanteBuilder builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public ResponseEntity<Fabricante> criar(FabricanteDto fabricanteDto) {
		
		if (fabricanteDto.getNome() != null && fabricanteDto.getNome() != "") {
			Optional<Fabricante> fabricanteExite = service.fabricanteExiste(fabricanteDto.getNome());
			
			if(!fabricanteExite.isPresent()) {
				Fabricante fabricante = service.criar(builder.construirFabricante(fabricanteDto));
				return new ResponseEntity<Fabricante>(fabricante, HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Fabricante>(HttpStatus.OK);
		
	}
	
	@Override
	public ResponseEntity<Fabricante> ler(Long id) {
		Optional<Fabricante> fabricante = service.ler(id);
		if (fabricante.isPresent()) {
			return new ResponseEntity<Fabricante>(fabricante.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Fabricante>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Fabricante> lerTudo() {
		return service.lerTudo();
	}

	@Override
	public ResponseEntity<Void> atualizar(Long id, FabricanteDto dto) {
		Optional<Fabricante> fabricanteStored = service.ler(id);
		if (fabricanteStored.isPresent()) {
			Fabricante fabricante = builder.construirFabricante(dto);
			service.atualizar(id, fabricante);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Void> deletar(Long id) {
		Optional<Fabricante> fabricanteStored = service.ler(id);
		if (fabricanteStored.isPresent()) {
			service.deletar(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
