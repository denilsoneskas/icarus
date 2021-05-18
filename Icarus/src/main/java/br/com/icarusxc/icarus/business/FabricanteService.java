package br.com.icarusxc.icarus.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.icarusxc.icarus.entity.Fabricante;
import br.com.icarusxc.icarus.repository.FabricanteRepository;

@Service
public class FabricanteService implements BaseService<Fabricante> {

	private FabricanteRepository repository;

	public FabricanteService(FabricanteRepository repository) {
		this.repository = repository;
	}

	@Override
	public Fabricante criar(Fabricante fabricante) {
		
		Optional<Fabricante> fabricanteExiste = repository.fabricanteExiste(fabricante.getNome());
		if (!fabricanteExiste.isPresent())
			return repository.criar(fabricante);
		
		System.out.println("Fabricante já cadastrado");
		return null;
	}

	@Override
	public Optional<Fabricante> ler(Long id) {
		return repository.ler(id);
	}

	@Override
	public List<Fabricante> lerTudo() {
		return repository.lerTudo();
	}

	@Override
	public void atualizar(Long id, Fabricante fabricante) {
		fabricante.setId(id);
		repository.atualizar(fabricante);
	}

	@Override
	public void deletar(Long id) {
		repository.deletar(id);
	}
	
	public Optional<Fabricante> fabricanteExiste(String nome) {
		Optional<Fabricante> fabricanteExiste = repository.fabricanteExiste(nome);
		return fabricanteExiste;
	}

}
