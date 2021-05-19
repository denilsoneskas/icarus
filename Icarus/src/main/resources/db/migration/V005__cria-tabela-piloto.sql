CREATE TABLE  IF NOT EXISTS piloto 
(
	id serial PRIMARY KEY,
	codigo int NOT NULL,	
	nome varchar(255) NOT NULL,
	dataNascimento date NOT NULL,
	logradouro varchar(255) NOT NULL,
	numero int NOT NULL,
	referencia varchar(255),
	complemento varchar(255),
	bairro varchar(255) NOT NULL,
	cidade_id integer NOT NULL,
	aeronave_id integer NOT NULL,
	clube_id integer NOT NULL,
	FOREIGN KEY (cidade_id) 
		REFERENCES cidade(id)	 
		ON UPDATE SET NULL 
		ON DELETE SET NULL,
	FOREIGN KEY (aeronave_id) 
		REFERENCES aeronave(id)	 
		ON UPDATE SET NULL 
		ON DELETE SET NULL,
	FOREIGN KEY (clube_id) 
		REFERENCES clube(id)	 
		ON UPDATE SET NULL 
		ON DELETE SET NULL
);