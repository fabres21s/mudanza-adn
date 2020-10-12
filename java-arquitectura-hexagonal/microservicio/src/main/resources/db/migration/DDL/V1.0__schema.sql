create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table festivo(
	id int(11) not null auto_increment,
	nombre varchar(100) not null,
	fecha date not null,
	fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
	primary key (id),
	CONSTRAINT uq_fecha UNIQUE (fecha)
);


insert into festivo (nombre, fecha) values ('Día de la raza', '2020-10-11');
insert into festivo (nombre, fecha) values ('Todos los santos', '2020-11-02');
insert into festivo (nombre, fecha) values ('Independencia de Cartagena', '2020-11-16');
insert into festivo (nombre, fecha) values ('Inmaculada concepción', '2020-12-08');
insert into festivo (nombre, fecha) values ('Día de navidad', '2020-12-25');

