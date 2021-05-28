CREATE TABLE  IF NOT EXISTS prova 
(
	id serial PRIMARY KEY,
	nome varchar(255) NOT NULL,
	dataProva date NOT NULL
);