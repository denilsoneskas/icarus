package br.com.icarusxc.icarus.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.icarusxc.icarus.entity.Cidade;
import br.com.icarusxc.icarus.repository.CidadeRepository;

@Service
public class CidadeService implements BaseService<Cidade> {

	private CidadeRepository repository;

	public CidadeService(CidadeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Cidade criar(Cidade cidade) {
		
		Optional<Cidade> cidadeExiste = repository.cidadeExiste(cidade.getNome());
		if (!cidadeExiste.isPresent())
			return repository.criar(cidade);
		
		System.out.println("Cidade já cadastrado");
		return null;
	}

	@Override
	public Optional<Cidade> ler(Long id) {
		return repository.ler(id);
	}

	@Override
	public List<Cidade> lerTudo() {
		return repository.lerTudo();
	}

	@Override
	public void atualizar(Long id, Cidade cidade) {
		cidade.setId(id);
		repository.atualizar(cidade);
	}

	@Override
	public void deletar(Long id) {
		repository.deletar(id);
	}
	
	public Optional<Cidade> cidadeExiste(String nome) {
		Optional<Cidade> cidadeExiste = repository.cidadeExiste(nome);
		return cidadeExiste;
	}

}
