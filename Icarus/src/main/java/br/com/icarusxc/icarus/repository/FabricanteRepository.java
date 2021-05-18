package br.com.icarusxc.icarus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.icarusxc.icarus.entity.Fabricante;
import br.com.icarusxc.icarus.repository.rowmapper.FabricanteRowMapper;

@Repository
public class FabricanteRepository implements BaseRepository<Fabricante> {

	private NamedParameterJdbcTemplate template;

	public FabricanteRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Fabricante criar(Fabricante fabricante) {

		String sql = "INSERT INTO fabricante (nome) VALUES (:nome) RETURNING *";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", fabricante.getNome());

		return template.queryForObject(sql, paramSource, new FabricanteRowMapper());
	}

	@Override
	public Optional<Fabricante> ler(Long id) {

		String sql = "SELECT * FROM fabricante WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new FabricanteRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Fabricante> lerTudo() {

		String sql = "SELECT * FROM fabricante ORDER BY id";

		return template.query(sql, new FabricanteRowMapper());
	}

	@Override
	public void atualizar(Fabricante fabricante) {

		String sql = "UPDATE fabricante SET nome = :nome WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", fabricante.getNome())
				.addValue("id", fabricante.getId());

		template.update(sql, paramSource);
	}

	@Override
	public void deletar(Long id) {

		String sql = "DELETE FROM fabricante WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);
		
		template.update(sql, paramSource);
	}
	
	public Optional<Fabricante> fabricanteExiste(String nome) {

		String sql = "SELECT * FROM fabricante WHERE nome = :nome";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", nome);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new FabricanteRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

}
