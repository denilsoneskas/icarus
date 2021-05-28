package br.com.icarusxc.icarus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.icarusxc.icarus.entity.Endereco;
import br.com.icarusxc.icarus.repository.rowmapper.EnderecoRowMapper;

@Repository
public class EnderecoRepository implements BaseRepository<Endereco> {

	private NamedParameterJdbcTemplate template;

	public EnderecoRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Endereco criar(Endereco endereco) {

		String sql = "INSERT INTO endereco "
				+ "(logradouro, numero, referencia, complemento, bairro, cidade_id, cep) VALUES "
				+ "(:logradouro, :numero, :referencia, :complemento, :bairro, :cidade_id, :cep) RETURNING id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("logradouro", endereco.getLogradouro())
				.addValue("numero", endereco.getNumero())
				.addValue("referencia", endereco.getReferencia())
				.addValue("complemento", endereco.getComplemento())
				.addValue("bairro", endereco.getBairro())
				.addValue("cidade_id", endereco.getCidade().getId())
				.addValue("cep", endereco.getCep());
		
		endereco.setId(template.queryForObject(sql, paramSource, Long.class));
		return endereco;
	}

	@Override
	public Optional<Endereco> ler(Long id) {

		String sql = "SELECT *,"
				+ " cidade.id AS cidade_id "
				+ " FROM endereco "
				+ " JOIN cidade ON cidade_id = cidade.id"
				+ " WHERE endereco.id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new EnderecoRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Endereco> lerTudo() {

		String sql = "SELECT *,"
				+ " cidade.id AS cidade_id "
				+ " FROM endereco "
				+ " JOIN cidade ON cidade_id = cidade.id"
				+ " ORDER BY endereco.id";

		return template.query(sql, new EnderecoRowMapper());
	}

	@Override
	public void atualizar(Endereco endereco) {

		String sql = "UPDATE endereco SET logradouro = :logradouro, numero = :numero, referencia = :referencia, complemento = :complemento, bairro = :bairro, cidade_id = :cidade_id, cep = :cep WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("logradouro", endereco.getLogradouro())
				.addValue("numero", endereco.getNumero())
				.addValue("referencia", endereco.getReferencia())
				.addValue("complemento", endereco.getComplemento())
				.addValue("bairro", endereco.getBairro())
				.addValue("cidade_id", endereco.getCidade().getId())
				.addValue("cep", endereco.getCep())
				.addValue("id", endereco.getId());

		template.update(sql, paramSource);
	}

	@Override
	public void deletar(Long id) {

		String sql = "DELETE FROM endereco WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);

		template.update(sql, paramSource);
	}
	
	public Optional<Endereco> enderecoExiste(String logradouro) {

		String sql = "SELECT *,"
				+ " cidade.id AS cidade_id "
				+ " FROM endereco "
				+ " JOIN cidade ON cidade_id = cidade.id"
				+ " WHERE endereco.logradouro = :logradouro";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("logradouro", logradouro);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new EnderecoRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

}
