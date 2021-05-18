CREATE TABLE  IF NOT EXISTS Aeronave 
(
	id serial PRIMARY KEY,
	fabricante_id integer NOT NULL,
	modelo varchar(255) NOT NULL,
	certificacao varchar(16) NOT NULL,
	FOREIGN KEY (fabricante_id) 
		REFERENCES fabricante(id) 
		ON UPDATE CASCADE 
		ON DELETE CASCADE
);