create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);


insert into usuario(id, nombre, clave,  fecha_creacion) values (1,'pensive', 'curie', '2019-01-01');
insert into usuario(id, nombre, clave,  fecha_creacion) values (2,'furious', 'hugle',  '2019-01-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (3,'aryabhata', 'trusting',  '2019-08-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (4,'lichterman', 'grave',  '1985-01-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (5,'sharp', 'heisenberg',  '1945-01-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (6,'stoic', 'sammet',  '1998-01-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (7,'fervent', 'sinoussi',  '2020-02-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (8,'agitated', 'bell',  '2018-12-31');
insert into usuario(id, nombre, clave,  fecha_creacion) values (9,'hopeful', 'bartik',  '2020-09-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (10,'trusting', 'bohr', '2019-01-01');
insert into usuario(id, nombre, clave,  fecha_creacion) values (11,'hungry', 'yonath',  '2019-01-01');
insert into usuario(id, nombre, clave,  fecha_creacion) values (12,'ecstatic', 'jennings', '2019-01-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (13,'sharp', 'bhabha',  '2019-08-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (14,'dreamy', 'brattain',  '1985-01-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (15,'elated', 'bhabha',  '1945-01-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (16,'cranky', 'pike',  '1998-01-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (17,'stupefied', 'lovelace',  '2020-02-02');
insert into usuario(id, nombre, clave,  fecha_creacion) values (18,'sick', 'bell',  '2018-12-31');
insert into usuario(id, nombre, clave,  fecha_creacion) values (19,'evil', 'lalande', '2020-09-02');