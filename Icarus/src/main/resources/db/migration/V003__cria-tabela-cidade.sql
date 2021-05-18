CREATE TABLE  IF NOT EXISTS cidade 
(
	id serial PRIMARY KEY,
	nome varchar(255) NOT NULL,
	cep varchar(15) NOT NULL,
	estado varchar(31) NOT NULL
);