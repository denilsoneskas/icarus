package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Clube;

public class ClubeRowMapper implements RowMapper<Clube> {

	@Override
	public Clube mapRow(ResultSet rs, int rowNum) throws SQLException {

		Clube clube = new Clube();
		clube.setId(rs.getLong("id"));
		clube.setNome(rs.getString("nome"));
		clube.setLogradouro(rs.getString("logradouro"));
		clube.setNumero(rs.getInt("numero"));
		clube.setReferencia(rs.getString("referencia"));
		clube.setComplemento(rs.getString("complemento"));
		clube.setBairro(rs.getString("bairro"));
		
		clube.setCidade(new CidadeRowMapper().mapRow(rs, rowNum));

		return clube;
	}

}
