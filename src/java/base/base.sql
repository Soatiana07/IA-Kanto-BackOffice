create database io;
create role io login password 'io';
alter database io owner to io;

create table admin(
id serial primary key,
nom varchar(255),
mdp varchar(255)
);
insert into admin(nom,mdp) values ('kanto','kanto');

create table utilisateur(
id serial primary key,
nom varchar(255),
mdp varchar(255)
);
insert into utilisateur(nom,mdp) values ('mia','mia');

create table type(
id serial primary key,
type varchar(255)
);
insert into type(type) values ('AI Business');
insert into type(type) values ('AI Trends');
insert into type(type) values ('AI News');
insert into type(type) values ('VentureBeat AI');

create table cible(
id serial primary key,
cible varchar(255)
);
insert into cible(cible) values ('public');
insert into cible(cible) values ('chercheur');
insert into cible(cible) values ('professionnel');

create table contenu(
id serial primary key,
idtype int,
idcible int,
idadmin int,
date date,
titre varchar(255),
description text
);
alter table contenu add foreign key(idtype) references type(id);
alter table contenu add foreign key(idcible) references cible(id);
alter table contenu add foreign key(idadmin) references admin(id);
create or replace view v_contenu as 
select contenu.*,cible.cible,type.type,admin.nom
from contenu
join cible on cible.id=contenu.idcible
join type on type.id= contenu.idtype
join admin on admin.id=contenu.idadmin;
