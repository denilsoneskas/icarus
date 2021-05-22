package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Etapa;

public class EtapaRowMapper implements RowMapper<Etapa> {

	@Override
	public Etapa mapRow(ResultSet rs, int rowNum) throws SQLException {

		Etapa etapa = new Etapa();
		etapa.setId(rs.getLong("id"));
		
		etapa.setProva(new ProvaRowMapper().mapRow(rs, rowNum));
		etapa.setPiloto(new PilotoRowMapper().mapRow(rs, rowNum));
		
		etapa.setDecolagem(rs.getDate("decolagem"));
		etapa.setPouso(rs.getDate("pouso"));
		etapa.setDistanciaMosca(rs.getDouble("distanciaMosca"));

		return etapa;
	}

}
