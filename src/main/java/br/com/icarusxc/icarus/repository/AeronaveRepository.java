package br.com.icarusxc.icarus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.icarusxc.icarus.entity.Aeronave;
import br.com.icarusxc.icarus.repository.rowmapper.AeronaveRowMapper;

@Repository
public class AeronaveRepository implements BaseRepository<Aeronave> {

	private NamedParameterJdbcTemplate template;

	public AeronaveRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Aeronave criar(Aeronave aeronave) {

		String sql = "INSERT INTO aeronave (fabricante_id, modelo, certificacao) VALUES (:fabricante_id, :modelo, :certificacao) RETURNING id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("fabricante_id", aeronave.getFabricante().getId())
				.addValue("modelo", aeronave.getModelo())
				.addValue("certificacao", aeronave.getCertificacao());

		
		aeronave.setId(template.queryForObject(sql, paramSource, Long.class));
		return aeronave;
	}

	@Override
	public Optional<Aeronave> ler(Long id) {

		String sql = "SELECT *,"
				+ " fabricante.id AS fabricante_id "
				+ " FROM aeronave"
				+ " JOIN fabricante ON fabricante_id = fabricante.id"
				+ " WHERE aeronave.id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new AeronaveRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Aeronave> lerTudo() {

		String sql = "SELECT *,"
				+ " fabricante.id AS fabricante_id "
				+ " FROM aeronave"
				+ " JOIN fabricante ON fabricante_id = fabricante.id"
				+ " ORDER BY aeronave.id";

		return template.query(sql, new AeronaveRowMapper());
	}

	@Override
	public void atualizar(Aeronave aeronave) {

		String sql = "UPDATE aeronave SET fabricante_id = :fabricante_id, modelo = :modelo, certificacao = :certificacao WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("fabricante_id", aeronave.getFabricante().getId())
				.addValue("modelo", aeronave.getModelo())
				.addValue("certificacao", aeronave.getCertificacao())
				.addValue("id", aeronave.getId());

		template.update(sql, paramSource);
	}

	@Override
	public void deletar(Long id) {

		String sql = "DELETE FROM aeronave WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);

		template.update(sql, paramSource);
	}
	
	public Optional<Aeronave> aeronaveExiste(String modelo) {

		String sql = "SELECT *,"
				+ " fabricante.id AS fabricante_id "
				+ " FROM aeronave"
				+ " JOIN fabricante ON fabricante_id = fabricante.id"
				+ " WHERE modelo = :modelo";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("modelo", modelo);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new AeronaveRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

}
