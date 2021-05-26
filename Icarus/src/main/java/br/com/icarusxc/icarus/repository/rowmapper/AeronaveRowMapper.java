package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Aeronave;

public class AeronaveRowMapper implements RowMapper<Aeronave> {

	@Override
	public Aeronave mapRow(ResultSet rs, int rowNum) throws SQLException {

		Aeronave aeronave = new Aeronave();
		
		try {
			aeronave.setId(rs.getLong("aeronave_id"));
		} catch (Exception e) {
			aeronave.setId(rs.getLong("id"));
		}
		
		aeronave.setFabricante(new FabricanteRowMapper().mapRow(rs, rowNum));
		
		aeronave.setModelo(rs.getString("modelo"));
		aeronave.setCertificacao(rs.getString("certificacao"));

		return aeronave;
	}

}
