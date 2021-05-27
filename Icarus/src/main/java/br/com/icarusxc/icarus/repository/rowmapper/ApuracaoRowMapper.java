package br.com.icarusxc.icarus.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.icarusxc.icarus.entity.Apuracao;

public class ApuracaoRowMapper implements RowMapper<Apuracao> {

	@Override
	public Apuracao mapRow(ResultSet rs, int rowNum) throws SQLException {

		Apuracao apuracaoDto = new Apuracao();
		
		apuracaoDto.setPilotoNnome(rs.getString("nome"));
		apuracaoDto.setAeronaveModelo(rs.getString("modelo"));
		apuracaoDto.setFabricanteNome(rs.getString("fabricante_nome"));
		apuracaoDto.setClubeNome(rs.getString("clube_nome"));
		
		try {
			apuracaoDto.setDecolagem(rs.getTimestamp("decolagem").toLocalDateTime());
			apuracaoDto.setPouso(rs.getTimestamp("pouso").toLocalDateTime());
			apuracaoDto.setPermanencia(rs.getTime("permanencia").toLocalTime());
		} catch (Exception e) {
		}
		
		apuracaoDto.setDistanciaMosca(rs.getDouble("distanciaMosca"));

		return apuracaoDto;
	}

}
