package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Fabricante;

public class FabricanteRowMapper implements RowMapper<Fabricante> {

	@Override
	public Fabricante mapRow(ResultSet rs, int rowNum) throws SQLException {

		Fabricante fabricante = new Fabricante();
		fabricante.setId(rs.getLong("id"));
		fabricante.setNome(rs.getString("nome"));

		return fabricante;
	}

}
