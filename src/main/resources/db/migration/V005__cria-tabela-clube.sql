CREATE TABLE  IF NOT EXISTS clube 
(
	id serial PRIMARY KEY,
	nome varchar(255) NOT NULL,
	endereco_id integer NOT NULL,
	FOREIGN KEY (endereco_id) 
		REFERENCES endereco(id) 
		ON UPDATE CASCADE 
		ON DELETE CASCADE
);