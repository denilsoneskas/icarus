CREATE TABLE  IF NOT EXISTS clube 
(
	id serial PRIMARY KEY,
	codigo int NOT NULL,	
	nome varchar(255) NOT NULL,
	dataNascimento date NOT NULL,
	logradrouro varchar(255) NOT NULL,
	numero int NOT NULL,
	referencia varchar(255),
	complemento varchar(255),
	bairro varchar(255) NOT NULL,
	cidade_id integer NOT NULL,
	aeronave_id integer NOT NULL,
	clube_id integer NOT NULL
);