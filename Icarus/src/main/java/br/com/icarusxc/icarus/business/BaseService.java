package br.com.icarusxc.icarus.business;

import java.util.List;
import java.util.Optional;

import br.com.icarusxc.icarus.entity.BaseEntity;

public interface BaseService<E extends BaseEntity> {

	public E criar(E entity);
	
	public Optional<E> ler(Long id);
	
	public List<E> lerTudo();
	
	public void atualizar(Long id, E e);
	
	public void deletar(Long id);
	
}
