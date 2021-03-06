package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Cidade;

public class CidadeRowMapper implements RowMapper<Cidade> {

	@Override
	public Cidade mapRow(ResultSet rs, int rowNum) throws SQLException {

		Cidade cidade = new Cidade();
		
		try {
			cidade.setId(rs.getLong("cidade_id"));
			cidade.setNome(rs.getString("cidade_nome"));
		} catch (Exception e) {
			cidade.setId(rs.getLong("id"));
			cidade.setNome(rs.getString("nome"));
		}
		
		cidade.setEstado(rs.getString("estado"));

		return cidade;
	}

}
