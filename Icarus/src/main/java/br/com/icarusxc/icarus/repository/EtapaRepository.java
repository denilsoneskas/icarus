package br.com.icarusxc.icarus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.icarusxc.icarus.entity.Etapa;
import br.com.icarusxc.icarus.repository.rowmapper.EtapaRowMapper;

@Repository
public class EtapaRepository implements BaseRepository<Etapa> {

	private NamedParameterJdbcTemplate template;

	public EtapaRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Etapa criar(Etapa etapa) {

		String sql = "INSERT INTO etapa (prova_id, piloto_id, decolagem, pouso, distanciaMosca) VALUES (:prova_id, :piloto_id, :decolagem, :pouso, :distanciaMosca) RETURNING id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("prova_id", etapa.getProva().getId())
				.addValue("piloto_id", etapa.getPiloto().getId())
				.addValue("decolagem", etapa.getDecolagem())
				.addValue("pouso", etapa.getPouso())
				.addValue("distanciaMosca", etapa.getDistanciaMosca());

		
		etapa.setId(template.queryForObject(sql, paramSource, Long.class));
		return etapa;
	}

	@Override
	public Optional<Etapa> ler(Long id) {

		String sql = "SELECT * FROM etapa"
				+ " JOIN prova ON prova_id = prova.id"
				+ " JOIN piloto ON piloto_id = piloto.id"
				+ " JOIN endereco ON endereco_id = endereco.id"
				+ " JOIN cidade ON cidade_id = cidade.id"
				+ " JOIN aeronave ON aeronave_id = aeronave.id"
				+ " JOIN fabricante ON fabricante_id = fabricante.id"
				+ " WHERE etapa.id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new EtapaRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Etapa> lerTudo() {

		String sql = "SELECT * FROM etapa"
				+ " JOIN prova ON prova_id = prova.id"
				+ " JOIN piloto ON piloto_id = piloto.id"
				+ " JOIN endereco ON endereco_id = endereco.id"
				+ " JOIN cidade ON cidade_id = cidade.id"
				+ " JOIN aeronave ON aeronave_id = aeronave.id"
				+ " JOIN fabricante ON fabricante_id = fabricante.id"
				+ " ORDER BY etapa.id";

		return template.query(sql, new EtapaRowMapper());
	}

	@Override
	public void atualizar(Etapa etapa) {

		String sql = "UPDATE etapa SET prova = :prova_id, piloto_id = :piloto_id, decolagem = :decolagem, pouso = :pouso, distanciaMosca = :distanciaMosca WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", etapa.getProva().getId())
				.addValue("piloto_id", etapa.getPiloto().getId())
				.addValue("decolagem", etapa.getDecolagem())
				.addValue("pouso", etapa.getPouso())
				.addValue("distanciaMosca", etapa.getDistanciaMosca())
				.addValue("id", etapa.getId());

		template.update(sql, paramSource);
	}

	@Override
	public void deletar(Long id) {

		String sql = "DELETE FROM etapa WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);

		template.update(sql, paramSource);
	}
	
	public Optional<Etapa> etapaExiste(String nome) {

		String sql = "SELECT * FROM etapa"
				+ " JOIN prova ON prova_id = prova.id"
				+ " JOIN piloto ON piloto_id = piloto.id"
				+ " JOIN endereco ON endereco_id = endereco.id"
				+ " JOIN cidade ON cidade_id = cidade.id"
				+ " JOIN aeronave ON aeronave_id = aeronave.id"
				+ " JOIN fabricante ON fabricante_id = fabricante.id"
				+ " WHERE nome = :nome";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", nome);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new EtapaRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

}
