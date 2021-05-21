package br.com.icarusxc.icarus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.icarusxc.icarus.entity.Clube;
import br.com.icarusxc.icarus.repository.rowmapper.ClubeRowMapper;

@Repository
public class ClubeRepository implements BaseRepository<Clube> {

	private NamedParameterJdbcTemplate template;

	public ClubeRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Clube criar(Clube clube) {

		String sql = "INSERT INTO clube (nome, endereco_id) VALUES (:nome, :endereco_id) RETURNING id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", clube.getNome())
				.addValue("endereco_id", clube.getEndereco().getId());
		
		clube.setId(template.queryForObject(sql, paramSource, Long.class));
		return clube;
	}

	@Override
	public Optional<Clube> ler(Long id) {

		String sql = "SELECT *, cidade.nome AS cidade_nome FROM clube"
				+ " JOIN endereco ON endereco_id = endereco.id"
				+ " JOIN cidade ON endereco.cidade_id = cidade.id"
				+ " WHERE clube.id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new ClubeRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Clube> lerTudo() {

		String sql = "SELECT *, cidade.nome AS cidade_nome FROM clube"
				+ " JOIN endereco ON endereco_id = endereco.id"
				+ " JOIN cidade ON endereco.cidade_id = cidade.id"
				+ " ORDER BY clube.id";

		return template.query(sql, new ClubeRowMapper());
	}

	@Override
	public void atualizar(Clube clube) {

		String sql = "UPDATE clube SET nome = :nome, endereco_id = :endereco_id WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", clube.getNome())
				.addValue("endereco_id", clube.getEndereco().getId())
				.addValue("id", clube.getId());

		template.update(sql, paramSource);
	}

	@Override
	public void deletar(Long id) {

		String sql = "DELETE FROM clube WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);

		template.update(sql, paramSource);
	}
	
	public Optional<Clube> clubeExiste(String nome) {

		String sql = "SELECT *, cidade.nome AS cidade_nome FROM clube"
				+ " JOIN endereco ON endereco_id = endereco.id"
				+ " JOIN cidade ON endereco.cidade_id = cidade.id"
				+ " WHERE clube.nome = :nome";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", nome);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new ClubeRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

}
