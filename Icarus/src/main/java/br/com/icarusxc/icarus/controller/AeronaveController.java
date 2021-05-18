package br.com.icarusxc.icarus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.icarusxc.icarus.business.AeronaveBuilder;
import br.com.icarusxc.icarus.business.AeronaveService;
import br.com.icarusxc.icarus.dto.AeronaveDto;
import br.com.icarusxc.icarus.entity.Aeronave;

@RestController
@RequestMapping("/aeronaves")
public class AeronaveController implements BaseController<AeronaveDto, Aeronave> {

	private AeronaveService service;
	private AeronaveBuilder builder;

	public AeronaveController(AeronaveService service, AeronaveBuilder builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public ResponseEntity<Aeronave> criar(AeronaveDto aeronaveDto) {
		
		if (aeronaveDto.getModelo() !=null && aeronaveDto.getModelo() != "") {
			Optional<Aeronave> aeronaveExiste = service.aeronaveExiste(aeronaveDto.getModelo());
			if (!aeronaveExiste.isPresent()) {
				Aeronave aeronave = service.criar(builder.construirAeronave(aeronaveDto));
				return new ResponseEntity<Aeronave>(aeronave, HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Aeronave>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Aeronave> ler(Long id) {
		Optional<Aeronave> aeronave = service.ler(id);
		if (aeronave.isPresent()) {
			return new ResponseEntity<Aeronave>(aeronave.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Aeronave>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Aeronave> lerTudo() {
		return service.lerTudo();
	}

	@Override
	public ResponseEntity<Void> atualizar(Long id, AeronaveDto dto) {
		Optional<Aeronave> aeronaveStored = service.ler(id);
		if (aeronaveStored.isPresent()) {
			Aeronave aeronave = builder.construirAeronaveAtualizado(dto);
			service.atualizar(id, aeronave);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Void> deletar(Long id) {
		Optional<Aeronave> aeronaveStored = service.ler(id);
		if (aeronaveStored.isPresent()) {
			service.deletar(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
