CREATE TABLE  IF NOT EXISTS etapa 
(
	id serial PRIMARY KEY,
	prova_id integer NOT NULL,
	piloto_id integer NOT NULL,
	decolagem date,
	pouso date,
	distanciaMosca double precision,
	FOREIGN KEY (prova_id) 
		REFERENCES prova(id)	 
		ON UPDATE SET NULL 
		ON DELETE SET NULL,
	FOREIGN KEY (piloto_id) 
		REFERENCES piloto(id)	 
		ON UPDATE SET NULL 
		ON DELETE SET NULL
);