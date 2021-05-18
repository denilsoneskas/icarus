package br.com.icarusxc.icarus.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.icarusxc.icarus.entity.Aeronave;
import br.com.icarusxc.icarus.repository.AeronaveRepository;

@Service
public class AeronaveService implements BaseService<Aeronave> {

	private AeronaveRepository repository;

	public AeronaveService(AeronaveRepository repository) {
		this.repository = repository;
	}

	@Override
	public Aeronave criar(Aeronave aeronave) {
		return repository.criar(aeronave);
	}

	@Override
	public Optional<Aeronave> ler(Long id) {
		return repository.ler(id);
	}

	@Override
	public List<Aeronave> lerTudo() {
		return repository.lerTudo();
	}

	@Override
	public void atualizar(Long id, Aeronave aeronave) {
		aeronave.setId(id);
		repository.atualizar(aeronave);
	}

	@Override
	public void deletar(Long id) {
		repository.deletar(id);
	}

	public Optional<Aeronave> aeronaveExiste(String modelo) {
		Optional<Aeronave> aeronaveExite = repository.aeronaveExiste(modelo);
		return aeronaveExite;
	}

}
