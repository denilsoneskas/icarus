package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Fabricante;

public class FabricanteRowMapper implements RowMapper<Fabricante> {

	@Override
	public Fabricante mapRow(ResultSet rs, int rowNum) throws SQLException {

		Fabricante fabricante = new Fabricante();
		
		try {
			fabricante.setId(rs.getLong("fabricante_id"));
			fabricante.setNome(rs.getString("fabricante_nome"));
		} catch (Exception e) {
			fabricante.setNome(rs.getString("nome"));
			fabricante.setId(rs.getLong("id"));
		}
		

		return fabricante;
	}

}
