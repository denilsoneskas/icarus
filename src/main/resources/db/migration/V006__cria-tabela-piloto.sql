CREATE TABLE  IF NOT EXISTS piloto 
(
	id serial PRIMARY KEY,
	codigo int NOT NULL,	
	nome varchar(255) NOT NULL,
	dataNascimento date NOT NULL,
	endereco_id integer NOT NULL,
	aeronave_id integer NOT NULL,
	clube_id integer NOT NULL,
	FOREIGN KEY (endereco_id) 
		REFERENCES endereco(id)	 
		ON UPDATE CASCADE 
		ON DELETE CASCADE,
	FOREIGN KEY (aeronave_id) 
		REFERENCES aeronave(id)	 
		ON UPDATE CASCADE 
		ON DELETE CASCADE,
	FOREIGN KEY (clube_id) 
		REFERENCES clube(id)	 
		ON UPDATE CASCADE 
		ON DELETE CASCADE
);