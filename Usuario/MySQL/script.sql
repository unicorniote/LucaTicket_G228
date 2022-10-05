CREATE DATABASE usuariosdb;
USE usuariosdb;

CREATE TABLE usuariosdb.usuario (
	id int not null auto_increment,
    nombre varchar(100),
    apellido varchar(100),
    email varchar(150) unique,
    pass varchar(20) not null,
    fechaAlta date, 
    PRIMARY KEY (id)
)