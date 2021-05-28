CREATE TABLE IF NOT EXISTS etapa 
(
	id serial PRIMARY KEY,
	prova_id integer NOT NULL,
	piloto_id integer NOT NULL,
	decolagem timestamp without time zone,
	pouso timestamp without time zone,
	permanencia time generated always AS (pouso-decolagem) stored,
	distanciaMosca double precision,
	FOREIGN KEY (prova_id) 
		REFERENCES prova(id)	 
		ON UPDATE CASCADE 
		ON DELETE CASCADE,
	FOREIGN KEY (piloto_id) 
		REFERENCES piloto(id)	 
		ON UPDATE CASCADE 
		ON DELETE CASCADE
);