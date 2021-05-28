package br.com.icarusxc.icarus.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.icarusxc.icarus.entity.Endereco;
import br.com.icarusxc.icarus.repository.EnderecoRepository;

@Service
public class EnderecoService implements BaseService<Endereco> {

	private EnderecoRepository repository;

	public EnderecoService(EnderecoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Endereco criar(Endereco endereco) {
		return repository.criar(endereco);
	}

	@Override
	public Optional<Endereco> ler(Long id) {
		return repository.ler(id);
	}

	@Override
	public List<Endereco> lerTudo() {
		return repository.lerTudo();
	}

	@Override
	public void atualizar(Long id, Endereco endereco) {
		endereco.setId(id);
		repository.atualizar(endereco);
	}

	@Override
	public void deletar(Long id) {
		repository.deletar(id);
	}

	public Optional<Endereco> enderecoExiste(String logradouro) {
		Optional<Endereco> enderecoExite = repository.enderecoExiste(logradouro);
		return enderecoExite;
	}

}
