CREATE TABLE  IF NOT EXISTS clube 
(
	id serial PRIMARY KEY,
	nome varchar(255) NOT NULL,
	logradouro varchar(255) NOT NULL,
	numero int NOT NULL,
	referencia varchar(255),
	complemento varchar(255),
	bairro varchar(255) NOT NULL,
	cidade_id integer NOT NULL,
	FOREIGN KEY (cidade_id) 
		REFERENCES cidade(id) 
		ON UPDATE CASCADE 
		ON DELETE CASCADE
);