package br.com.icarusxc.icarus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.icarusxc.icarus.business.EnderecoBuilder;
import br.com.icarusxc.icarus.business.EnderecoService;
import br.com.icarusxc.icarus.dto.EnderecoDto;
import br.com.icarusxc.icarus.entity.Endereco;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController implements BaseController<EnderecoDto, Endereco> {

	private EnderecoService service;
	private EnderecoBuilder builder;

	public EnderecoController(EnderecoService service, EnderecoBuilder builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public ResponseEntity<Endereco> criar(EnderecoDto dto) {
		
		if (dto.getLogradouro() !=null && dto.getLogradouro() != "") {
			Optional<Endereco> enderecoExiste = service.enderecoExiste(dto.getLogradouro());
			if (!enderecoExiste.isPresent()) {
				Endereco endereco = service.criar(builder.construirEndereco(dto));
				return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Endereco>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Endereco> ler(Long id) {
		Optional<Endereco> endereco = service.ler(id);
		if (endereco.isPresent()) {
			return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Endereco> lerTudo() {
		return service.lerTudo();
	}

	@Override
	public ResponseEntity<Void> atualizar(Long id, EnderecoDto dto) {
		Optional<Endereco> enderecoStored = service.ler(id);
		if (enderecoStored.isPresent()) {
			Endereco endereco = builder.construirEnderecoAtualizado(dto);
			service.atualizar(id, endereco);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Void> deletar(Long id) {
		Optional<Endereco> enderecoStored = service.ler(id);
		if (enderecoStored.isPresent()) {
			service.deletar(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
