package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Piloto;

public class PilotoRowMapper implements RowMapper<Piloto> {

	@Override
	public Piloto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Piloto piloto = new Piloto();
		
		piloto.setCodigo(rs.getInt("codigo"));
		
		try {
			piloto.setId(rs.getLong("piloto_id"));
			piloto.setNome(rs.getString("piloto_nome"));
		} catch (Exception e) {
			piloto.setId(rs.getLong("id"));
			piloto.setNome(rs.getString("nome"));
		}
		
		piloto.setDataNascimento(rs.getDate("dataNascimento"));
		
		piloto.setEndereco(new EnderecoRowMapper().mapRow(rs, rowNum));
		piloto.setAeronave(new AeronaveRowMapper().mapRow(rs, rowNum));
		piloto.setClube(new ClubeRowMapper().mapRow(rs, rowNum));

		return piloto;
	}

}
