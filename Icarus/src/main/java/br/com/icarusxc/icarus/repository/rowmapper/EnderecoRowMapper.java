package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Endereco;

public class EnderecoRowMapper implements RowMapper<Endereco> {

	@Override
	public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Endereco endereco = new Endereco();
		try {
			endereco.setId(rs.getLong("endereco_id"));
		} catch (Exception e) {
			endereco.setId(rs.getLong("id"));
		}
		endereco.setLogradouro(rs.getString("logradouro"));
		endereco.setNumero(rs.getInt("numero"));
		endereco.setReferencia(rs.getString("referencia"));
		endereco.setComplemento(rs.getString("complemento"));
		endereco.setBairro(rs.getString("bairro"));
		
		endereco.setCidade(new CidadeRowMapper().mapRow(rs, rowNum));

		endereco.setCep(rs.getString("cep"));
		
		return endereco;
	}

}
