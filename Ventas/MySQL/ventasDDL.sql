create database ventasdb;
use ventasdb;

create table ventasdb.ventas(
	id int auto_increment,
    usuario int not null,
    evento varchar(30) not null,
    primary key(id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci