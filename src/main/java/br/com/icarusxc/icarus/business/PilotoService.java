package br.com.icarusxc.icarus.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.icarusxc.icarus.entity.Piloto;
import br.com.icarusxc.icarus.repository.PilotoRepository;

@Service
public class PilotoService implements BaseService<Piloto> {

	private PilotoRepository repository;

	public PilotoService(PilotoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Piloto criar(Piloto piloto) {
		return repository.criar(piloto);
	}

	@Override
	public Optional<Piloto> ler(Long id) {
		return repository.ler(id);
	}

	@Override
	public List<Piloto> lerTudo() {
		return repository.lerTudo();
	}

	@Override
	public void atualizar(Long id, Piloto piloto) {
		piloto.setId(id);
		repository.atualizar(piloto);
	}

	@Override
	public void deletar(Long id) {
		repository.deletar(id);
	}

	public Optional<Piloto> pilotoExiste(String modelo) {
		Optional<Piloto> pilotoExite = repository.pilotoExiste(modelo);
		return pilotoExite;
	}

}
