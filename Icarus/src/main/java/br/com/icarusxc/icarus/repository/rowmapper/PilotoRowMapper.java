package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Piloto;

public class PilotoRowMapper implements RowMapper<Piloto> {

	@Override
	public Piloto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Piloto piloto = new Piloto();
		piloto.setId(rs.getLong("id"));
		piloto.setCodigo(rs.getInt("codigo"));
		piloto.setNome(rs.getString("nome"));
		piloto.setDataNascimento(rs.getDate("dataNascimento"));
		piloto.setLogradouro(rs.getString("logradouro"));
		piloto.setNumero(rs.getInt("numero"));
		piloto.setReferencia(rs.getString("referencia"));
		piloto.setComplemento(rs.getString("complemento"));
		piloto.setBairro(rs.getString("bairro"));
		
		piloto.setCidade(new CidadeRowMapper().mapRow(rs, rowNum));
		piloto.setAeronave(new AeronaveRowMapper().mapRow(rs, rowNum));
		piloto.setClube(new ClubeRowMapper().mapRow(rs, rowNum));

		return piloto;
	}

}
