CREATE VIEW apuracao_distanciamosca_view AS
	SELECT prova_id, piloto.nome, aeronave.modelo, fabricante.nome AS fabricante_nome, clube.nome AS clube_nome,decolagem, pouso, permanencia, distanciamosca FROM etapa
	JOIN piloto ON piloto_id = piloto.id 
	JOIN clube ON clube_id = clube.id
	JOIN aeronave ON piloto.aeronave_id = aeronave.id
	JOIN fabricante ON aeronave.fabricante_id = fabricante.id
	ORDER BY distanciamosca DESC, permanencia DESC