package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Etapa;

public class EtapaRowMapper implements RowMapper<Etapa> {

	@Override
	public Etapa mapRow(ResultSet rs, int rowNum) throws SQLException {

		Etapa etapa = new Etapa();
		
		try {
			etapa.setId(rs.getLong("etapa_id"));
		} catch (Exception e) {
			etapa.setId(rs.getLong("id"));
		}
		
		etapa.setProva(new ProvaRowMapper().mapRow(rs, rowNum));
		etapa.setPiloto(new PilotoRowMapper().mapRow(rs, rowNum));
		
		try {
			etapa.setDecolagem(rs.getTimestamp("decolagem").toLocalDateTime());
			etapa.setPouso(rs.getTimestamp("pouso").toLocalDateTime());
			etapa.setPermanencia(rs.getTime("permanencia").toLocalTime());
		} catch (Exception e) {
		}
		
		etapa.setDistanciaMosca(rs.getDouble("distanciaMosca"));

		return etapa;
	}

}
