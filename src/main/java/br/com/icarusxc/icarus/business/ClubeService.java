package br.com.icarusxc.icarus.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.icarusxc.icarus.entity.Clube;
import br.com.icarusxc.icarus.repository.ClubeRepository;

@Service
public class ClubeService implements BaseService<Clube> {

	private ClubeRepository repository;

	public ClubeService(ClubeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Clube criar(Clube clube) {
		return repository.criar(clube);
	}

	@Override
	public Optional<Clube> ler(Long id) {
		return repository.ler(id);
	}

	@Override
	public List<Clube> lerTudo() {
		return repository.lerTudo();
	}

	@Override
	public void atualizar(Long id, Clube clube) {
		clube.setId(id);
		repository.atualizar(clube);
	}

	@Override
	public void deletar(Long id) {
		repository.deletar(id);
	}

	public Optional<Clube> clubeExiste(String nome) {
		Optional<Clube> clubeExite = repository.clubeExiste(nome);
		return clubeExite;
	}

}
