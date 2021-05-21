package br.com.icarusxc.icarus.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.icarusxc.icarus.dto.EnderecoDto;
import br.com.icarusxc.icarus.entity.Endereco;

@Component
public class EnderecoBuilder {

	@Autowired
	private CidadeService cidadeService;
	
	public Endereco construirEndereco(EnderecoDto dto) {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(dto.getLogradouro());
		endereco.setNumero(dto.getNumero());
		endereco.setReferencia(dto.getReferencia());
		endereco.setComplemento(dto.getComplemento());
		endereco.setBairro(dto.getBairro());

		cidadeService.ler(dto.getCidade()).ifPresent(endereco::setCidade);
		
		endereco.setCep(dto.getCep());

		return endereco;
	}

	public Endereco construirEnderecoAtualizado(EnderecoDto dto) {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(dto.getLogradouro());
		endereco.setNumero(dto.getNumero());
		endereco.setReferencia(dto.getReferencia());
		endereco.setComplemento(dto.getComplemento());
		endereco.setBairro(dto.getBairro());

		cidadeService.ler(dto.getCidade()).ifPresent(endereco::setCidade);
		
		endereco.setCep(dto.getCep());
		
		return endereco;
	}

}
