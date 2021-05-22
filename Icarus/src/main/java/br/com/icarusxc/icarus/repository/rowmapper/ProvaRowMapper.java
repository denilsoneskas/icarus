package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Prova;

public class ProvaRowMapper implements RowMapper<Prova> {

	@Override
	public Prova mapRow(ResultSet rs, int rowNum) throws SQLException {

		Prova prova = new Prova();
		prova.setId(rs.getLong("id"));
		
		try {
			prova.setNome(rs.getString("prova_nome"));
		} catch (Exception e) {
			prova.setNome(rs.getString("nome"));
		}
		
		prova.setDataProva(rs.getDate("dataProva"));
		
		return prova;
	}

}
