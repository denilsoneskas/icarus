package br.com.icarusxc.icarus.repository;

import java.util.List;
import java.util.Optional;

import br.com.icarusxc.icarus.entity.BaseEntity;

public interface BaseRepository<E extends BaseEntity> {

	// CRUD = CREATE, READ, UPDATE, DELETE
	public E criar(E entity);
	
	public Optional<E> ler(Long id);
	
	public List<E> lerTudo();
	
	public void atualizar(E entity);
	
	public void deletar(Long id);
	
}
