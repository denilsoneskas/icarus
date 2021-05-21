package br.com.icarusxc.icarus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.icarusxc.icarus.entity.Piloto;
import br.com.icarusxc.icarus.repository.rowmapper.PilotoRowMapper;

@Repository
public class PilotoRepository implements BaseRepository<Piloto> {

	private NamedParameterJdbcTemplate template;

	public PilotoRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Piloto criar(Piloto piloto) {

		String sql = "INSERT INTO piloto "
				+ "(codigo, nome, dataNascimento, endereco_id, aeronave_id, clube_id) VALUES "
				+ "(:codigo, :nome, :dataNascimento, :endereco_id, :aeronave_id, :clube_id) RETURNING id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("codigo", piloto.getCodigo())
				.addValue("nome", piloto.getNome())
				.addValue("dataNascimento", piloto.getDataNascimento())
				.addValue("endereco_id", piloto.getEndereco().getId())
				.addValue("aeronave_id", piloto.getAeronave().getId())
				.addValue("clube_id", piloto.getClube().getId());
		
		piloto.setId(template.queryForObject(sql, paramSource, Long.class));
		return piloto;
	}

	@Override
	public Optional<Piloto> ler(Long id) {

		String sql = "SELECT *, cidade.nome AS cidade_nome, clube.nome AS clube_nome FROM piloto "
				+ " JOIN endereco ON endereco_id = endereco.id"
				+ " JOIN cidade ON endereco.cidade_id = cidade.id"
				+ " JOIN aeronave ON aeronave_id = aeronave.id"
				+ " JOIN clube ON clube_id = clube.id"
				+ " WHERE piloto.id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new PilotoRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Piloto> lerTudo() {

		String sql = "SELECT *, cidade.nome AS cidade_nome, clube.nome AS clube_nome FROM piloto "
				+ " JOIN endereco ON endereco_id = endereco.id"
				+ " JOIN cidade ON endereco.cidade_id = cidade.id"
				+ " JOIN aeronave ON aeronave_id = aeronave.id"
				+ " JOIN clube ON clube_id = clube.id"
				+ " ORDER BY piloto.id";

		return template.query(sql, new PilotoRowMapper());
	}

	@Override
	public void atualizar(Piloto piloto) {

		String sql = "UPDATE piloto SET codigo = :codigo, nome = :nome, dataNascimento = :dataNascimento, endereco_id = :endereco_id, aeronave_id = :aeronave_id, clube_id = :clube_id WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("codigo", piloto.getCodigo())
				.addValue("nome", piloto.getNome())
				.addValue("dataNascimento", piloto.getDataNascimento())
				.addValue("endereco_id", piloto.getEndereco().getId())
				.addValue("aeronave_id", piloto.getAeronave().getId())
				.addValue("clube_id", piloto.getClube().getId())
				.addValue("id", piloto.getId());

		template.update(sql, paramSource);
	}

	@Override
	public void deletar(Long id) {

		String sql = "DELETE FROM piloto WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);

		template.update(sql, paramSource);
	}
	
	public Optional<Piloto> pilotoExiste(String nome) {

		String sql = "SELECT *, cidade.nome AS cidade_nome, clube.nome AS clube_nome FROM piloto "
				+ " JOIN endereco ON endereco_id = endereco.id"
				+ " JOIN cidade ON endereco.cidade_id = cidade.id"
				+ " JOIN aeronave ON aeronave_id = aeronave.id"
				+ " JOIN clube ON clube_id = clube.id"
				+ " WHERE piloto.nome = :nome";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", nome);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new PilotoRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

}
