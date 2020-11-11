CREATE DATABASE contacts;

use contacts; 

CREATE TABLE contatos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_date datetime DEFAULT NULL,
  email varchar(255) NOT NULL,
  nome varchar(255)  NOT NULL,
  sexo char(1)  NOT NULL,
  telefone varchar(255)  NOT NULL,
  updated_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;