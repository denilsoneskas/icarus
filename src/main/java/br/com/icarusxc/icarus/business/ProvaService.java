package br.com.icarusxc.icarus.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.icarusxc.icarus.entity.Prova;
import br.com.icarusxc.icarus.repository.ProvaRepository;

@Service
public class ProvaService implements BaseService<Prova> {

	private ProvaRepository repository;

	public ProvaService(ProvaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Prova criar(Prova prova) {
		return repository.criar(prova);
	}

	@Override
	public Optional<Prova> ler(Long id) {
		return repository.ler(id);
	}

	@Override
	public List<Prova> lerTudo() {
		return repository.lerTudo();
	}

	@Override
	public void atualizar(Long id, Prova prova) {
		prova.setId(id);
		repository.atualizar(prova);
	}

	@Override
	public void deletar(Long id) {
		repository.deletar(id);
	}

	public Optional<Prova> provaExiste(String nome) {
		Optional<Prova> provaExite = repository.provaExiste(nome);
		return provaExite;
	}

}
