package br.com.icarusxc.icarus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.icarusxc.icarus.entity.Cidade;
import br.com.icarusxc.icarus.repository.rowmapper.CidadeRowMapper;

@Repository
public class CidadeRepository implements BaseRepository<Cidade> {

	private NamedParameterJdbcTemplate template;

	public CidadeRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Cidade criar(Cidade cidade) {

		String sql = "INSERT INTO cidade (nome, estado) VALUES (:nome, :estado) RETURNING *";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", cidade.getNome())
				.addValue("estado", cidade.getEstado());

		return template.queryForObject(sql, paramSource, new CidadeRowMapper());
	}

	@Override
	public Optional<Cidade> ler(Long id) {

		String sql = "SELECT * FROM cidade WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new CidadeRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Cidade> lerTudo() {

		String sql = "SELECT * FROM cidade ORDER BY id";

		return template.query(sql, new CidadeRowMapper());
	}

	@Override
	public void atualizar(Cidade cidade) {

		String sql = "UPDATE cidade SET nome = :nome, estado = :estado WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", cidade.getNome())
				.addValue("estado", cidade.getEstado())
				.addValue("id",	cidade.getId());

		template.update(sql, paramSource);
	}

	@Override
	public void deletar(Long id) {

		String sql = "DELETE FROM cidade WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);

		template.update(sql, paramSource);
	}

	public Optional<Cidade> cidadeExiste(String nome) {

		String sql = "SELECT * FROM cidade WHERE nome = :nome";
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("nome", nome);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new CidadeRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

}
