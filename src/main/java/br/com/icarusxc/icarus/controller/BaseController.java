package br.com.icarusxc.icarus.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.icarusxc.icarus.dto.BaseDto;
import br.com.icarusxc.icarus.entity.BaseEntity;

public interface BaseController<D extends BaseDto, E extends BaseEntity> {

	// POST - PUBLICAR/CRIAR
	@PostMapping
	public ResponseEntity<E> criar(@RequestBody D dto);

	// GET - OBTER/PEGAR/LER
	@GetMapping("/{id}")
	public ResponseEntity<E> ler(@PathVariable Long id);

	// GET - OBTER/PEGAR/LER
	@GetMapping
	public List<E> lerTudo();

	// PUT - ATUALIZAR
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody D dto);

	// DELETE - DELETAR
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id);

}
