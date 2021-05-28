package br.com.icarusxc.icarus.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.icarusxc.icarus.entity.Apuracao;
import br.com.icarusxc.icarus.repository.rowmapper.ApuracaoRowMapper;

@Repository
public class ApuracaoRepository {

	private NamedParameterJdbcTemplate template;

	public ApuracaoRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	public List<Apuracao> apurarPermanencia(Long id) {
		
		String sql = "SELECT * FROM apuracao_permanencia_view WHERE prova_id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);
		
		return (List<Apuracao>) template.query(sql, paramSource, new ApuracaoRowMapper());
	}
	
	public List<Apuracao> apurarDistanciaMosca(Long id) {
		
		String sql = "SELECT * FROM apuracao_distanciamosca_view WHERE prova_id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);
		
		return (List<Apuracao>) template.query(sql, paramSource, new ApuracaoRowMapper());
	}
	
}
