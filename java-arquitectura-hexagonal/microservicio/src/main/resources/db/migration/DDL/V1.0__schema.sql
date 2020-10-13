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
	CONSTRAINT uq_festivo_fecha UNIQUE (fecha)
);


insert into festivo (nombre, fecha) values ('Día de la raza', '2020-10-11');
insert into festivo (nombre, fecha) values ('Todos los santos', '2020-11-02');
insert into festivo (nombre, fecha) values ('Independencia de Cartagena', '2020-11-16');
insert into festivo (nombre, fecha) values ('Inmaculada concepción', '2020-12-08');
insert into festivo (nombre, fecha) values ('Día de navidad', '2020-12-25');


create table tarifa(
	id int(11) not null auto_increment,
	nombre varchar(100) not null,
	fecha_inicial datetime not null,
	fecha_final datetime not null,
	valor double,
	porcentaje_recargo_nocturno double,
	porcentaje_recargo_dominical double,
	porcentaje_recargo_festivo double,
	cantidad_trabajadores int,
	porcentaje_trabajadores double,
	cantidad_furgones int,
	fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
	primary key (id)
);

insert into tarifa(nombre, fecha_inicial, fecha_final, valor, porcentaje_recargo_nocturno, porcentaje_recargo_dominical, porcentaje_recargo_festivo,
cantidad_trabajadores, porcentaje_trabajadores, cantidad_furgones) 
values ('Tarifa fin de año', '2020-10-01', '2020-12-31', 500000, 10, 15, 20, 3, 60, 1);

create table horario(
	id int(11) not null auto_increment,
	hora_inicial time not null,
	hora_final time not null,
	fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
	primary key (id)
);

insert into horario(hora_inicial, hora_final) values
('02:00:00', '06:00:00'),
('08:00:00', '12:00:00'),
('14:00:00', '18:00:00'),
('19:00:00', '23:00:00');

create table tarifa_horario(
	id int(11) not null auto_increment,
	tarifa_id int,
	horario_id int,
	recargo_nocturno bool,
	fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
	primary key (id),
	foreign key (tarifa_id) references tarifa(id),
	foreign key (horario_id) references horario(id)
);

insert into tarifa_horario(tarifa_id, horario_id, recargo_nocturno) values
(1,1, true),
(1,2, false),
(1,3, false),
(1,4, true);


create table furgon(
	id int(11) not null auto_increment,
	placa varchar(10),
	fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
	primary key (id),
	CONSTRAINT uq_furgon_placa UNIQUE (placa)
);

insert into furgon(placa) values ('ABC-123');

create table mudanza(
	id int(11) not null auto_increment,
	fecha datetime not null,
	tarifa_horario_id int,
	furgon_id int,
	tarifa_base double,
	recargo_nocturno double,
	recargo_dominical double,
	recargo_festivo double,
	direccion_inicial varchar(500),
	direccion_final varchar(500),
	fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
	primary key (id),
	foreign key (tarifa_horario_id) references tarifa_horario(id),
	foreign key (furgon_id) references furgon(id)
);
