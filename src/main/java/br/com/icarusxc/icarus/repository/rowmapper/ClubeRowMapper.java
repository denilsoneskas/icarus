package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Clube;

public class ClubeRowMapper implements RowMapper<Clube> {

	@Override
	public Clube mapRow(ResultSet rs, int rowNum) throws SQLException {

		Clube clube = new Clube();

		try {
			clube.setId(rs.getLong("clube_id"));
			clube.setNome(rs.getString("clube_nome"));
		} catch (Exception e) {
			clube.setId(rs.getLong("id"));
			clube.setNome(rs.getString("nome"));
		}
		
		clube.setEndereco(new EnderecoRowMapper().mapRow(rs, rowNum));
		
		return clube;
	}

}
