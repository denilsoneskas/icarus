CREATE TABLE  IF NOT EXISTS endereco 
(
	id serial PRIMARY KEY,
	logradouro varchar(255) NOT NULL,
	numero int NOT NULL,
	referencia varchar(255),
	complemento varchar(255),
	bairro varchar(255) NOT NULL,
	cep varchar(15) NOT NULL,
	cidade_id integer NOT NULL,
	FOREIGN KEY (cidade_id) 
		REFERENCES cidade(id)	 
		ON UPDATE SET NULL 
		ON DELETE SET NULL
);