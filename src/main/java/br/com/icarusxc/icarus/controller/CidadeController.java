package br.com.icarusxc.icarus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.icarusxc.icarus.business.CidadeBuilder;
import br.com.icarusxc.icarus.business.CidadeService;
import br.com.icarusxc.icarus.dto.CidadeDto;
import br.com.icarusxc.icarus.entity.Cidade;

@RestController
@RequestMapping("/cidades")
public class CidadeController implements BaseController<CidadeDto, Cidade> {

	private CidadeService service;
	private CidadeBuilder builder;
	
	public CidadeController(CidadeService service, CidadeBuilder builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public ResponseEntity<Cidade> criar(CidadeDto cidadeDto) {
		
		if (cidadeDto.getNome() != null && cidadeDto.getNome() != "") {
			Optional<Cidade> cidadeExite = service.cidadeExiste(cidadeDto.getNome());
			
			if(!cidadeExite.isPresent()) {
				Cidade cidade = service.criar(builder.construirCidade(cidadeDto));
				return new ResponseEntity<Cidade>(cidade, HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Cidade>(HttpStatus.OK);
		
	}
	
	@Override
	public ResponseEntity<Cidade> ler(Long id) {
		Optional<Cidade> cidade = service.ler(id);
		if (cidade.isPresent()) {
			return new ResponseEntity<Cidade>(cidade.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Cidade>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Cidade> lerTudo() {
		return service.lerTudo();
	}

	@Override
	public ResponseEntity<Void> atualizar(Long id, CidadeDto dto) {
		Optional<Cidade> cidadeStored = service.ler(id);
		if (cidadeStored.isPresent()) {
			Cidade cidade = builder.construirCidade(dto);
			service.atualizar(id, cidade);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Void> deletar(Long id) {
		Optional<Cidade> cidadeStored = service.ler(id);
		if (cidadeStored.isPresent()) {
			service.deletar(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
