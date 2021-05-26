package br.com.icarusxc.icarus.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.icarusxc.icarus.entity.Etapa;
import br.com.icarusxc.icarus.repository.EtapaRepository;

@Service
public class EtapaService implements BaseService<Etapa> {

	private EtapaRepository repository;

	public EtapaService(EtapaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Etapa criar(Etapa etapa) {
		return repository.criar(etapa);
	}

	@Override
	public Optional<Etapa> ler(Long id) {
		return repository.ler(id);
	}

	@Override
	public List<Etapa> lerTudo() {
		return repository.lerTudo();
	}

	@Override
	public void atualizar(Long id, Etapa etapa) {
		etapa.setId(id);
		repository.atualizar(etapa);
	}

	@Override
	public void deletar(Long id) {
		repository.deletar(id);
	}

	public Optional<Etapa> etapaExiste(String nome) {
		Optional<Etapa> etapaExite = repository.etapaExiste(nome);
		return etapaExite;
	}
	
}
