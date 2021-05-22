package br.com.icarusxc.icarus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.icarusxc.icarus.entity.Prova;
import br.com.icarusxc.icarus.repository.rowmapper.ProvaRowMapper;

@Repository
public class ProvaRepository implements BaseRepository<Prova> {

	private NamedParameterJdbcTemplate template;

	public ProvaRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Prova criar(Prova prova) {

		String sql = "INSERT INTO prova (nome, dataProva) VALUES (:nome, :dataProva) RETURNING id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", prova.getNome())
				.addValue("dataProva", prova.getDataProva());
		
		prova.setId(template.queryForObject(sql, paramSource, Long.class));
		return prova;
	}

	@Override
	public Optional<Prova> ler(Long id) {

		String sql = "SELECT * FROM prova WHERE prova.id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new ProvaRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Prova> lerTudo() {

		String sql = "SELECT * FROM prova ORDER BY prova.id";

		return template.query(sql, new ProvaRowMapper());
	}

	@Override
	public void atualizar(Prova prova) {

		String sql = "UPDATE prova SET nome = :nome, dataProva = :dataProva WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", prova.getNome())
				.addValue("dataProva", prova.getDataProva())
				.addValue("id", prova.getId());

		template.update(sql, paramSource);
	}

	@Override
	public void deletar(Long id) {

		String sql = "DELETE FROM prova WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);

		template.update(sql, paramSource);
	}
	
	public Optional<Prova> provaExiste(String nome) {

		String sql = "SELECT * FROM prova WHERE nome = :nome";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", nome);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new ProvaRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

}
