/*nom de la base : test*/

--drop database test;

CREATE DATABASE test
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


create table gameversion(
	gameversion_id serial,
	gameversion_label varchar(8) not null,
	
	constraint pk_gameversion primary key (gameversion_id)
);

create table mod(
	mod_id serial,
	mod_label varchar(50) not null,
	
	constraint pk_mod primary key (mod_id),
	constraint unique_mod_label unique (mod_label),
		
);


create table modversion(
	modversion_id serial,
	modversion_label varchar(20) not null,
	
	modversion_unMod int,
	modversion_uneVersion int,
	
	constraint pk_modversion primary key (modversion_id),
	constraint fk_unMod foreign key (modversion_unMod) references mod (mod_id),
	constraint fk_modversion_uneVersion foreign key (modversion_uneVersion) references gameversion (gameversion_id)
);

--create table typemodversion(
--typemodversion_id int,
--typemodversion_libelle varchar(50),
--
--constraint pk_typemodversion primary key (typemodversion_id));

---------------------------------------------------------------------------------

create view SoftwareCheckUpdates
as select *
from gameversion
inner join modversion
on gameversion_id = modversion_uneVersion
inner join mod
on mod_id = modversion_unmod
order by gameversion_label asc, mod_label, modversion_label;

--------------------------------------------------------------------------------

insert into gameversion (gameversion_label) values('1.7.2');
insert into gameversion (gameversion_label) values('1.7.4');
insert into gameversion (gameversion_label) values('1.7.5');
insert into gameversion (gameversion_label) values('1.7.6');
insert into gameversion (gameversion_label) values('1.7.7');
insert into gameversion (gameversion_label) values('1.7.8');
insert into gameversion (gameversion_label) values('1.7.9');
insert into gameversion (gameversion_label) values('1.7.10');
insert into gameversion (gameversion_label) values('1.8');
insert into gameversion (gameversion_label) values('1.8.1');
insert into gameversion (gameversion_label) values('1.8.2');
insert into gameversion (gameversion_label) values('1.8.3');
insert into gameversion (gameversion_label) values('1.8.4');
insert into gameversion (gameversion_label) values('1.8.5');
insert into gameversion (gameversion_label) values('1.8.6');
insert into gameversion (gameversion_label) values('1.8.7');
insert into gameversion (gameversion_label) values('1.8.8');
insert into gameversion (gameversion_label) values('1.8.9');
insert into gameversion (gameversion_label) values('1.9');
insert into gameversion (gameversion_label) values('1.9.1');
insert into gameversion (gameversion_label) values('1.9.2');
insert into gameversion (gameversion_label) values('1.9.3');
insert into gameversion (gameversion_label) values('1.9.4');
insert into gameversion (gameversion_label) values('1.10');
insert into gameversion (gameversion_label) values('1.10.1');
insert into gameversion (gameversion_label) values('1.10.2');
insert into gameversion (gameversion_label) values('1.11');

insert into mod (mod_label) values ('industrial craft');
insert into mod (mod_label) values ('buildcraft');
insert into mod (mod_label) values ('applied energistic');
insert into mod (mod_label) values ('agricraft');
insert into mod (mod_label) values ('logistic pipes');
insert into mod (mod_label) values ('JourneyMap');
insert into mod (mod_label) values ('Tinkers Construct');
insert into mod (mod_label) values ('Extra Utilities');
insert into mod (mod_label) values ('Mantle');
insert into mod (mod_label) values ('Storage Drawers');
insert into mod (mod_label) values ('Iron Chests');
insert into mod (mod_label) values ('Chisel');
insert into mod (mod_label) values ('Ender IO');
insert into mod (mod_label) values ('Immersive Engineering');
insert into mod (mod_label) values ('RFTools');
insert into mod (mod_label) values ('Baubles');
insert into mod (mod_label) values ('Inventory Tweaks');
insert into mod (mod_label) values ('Morpheus');
insert into mod (mod_label) values ('RFTools');
insert into mod (mod_label) values ('Baubles');

insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.2', 1, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 1, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.3', 1, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.7', 1, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.1.2', 1, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.9.8', 1, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.2', 2, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 2, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.3', 2, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.7', 2, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.1.2', 2, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.9.8', 2, 1);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.2', 3, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 3, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.3', 3, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.7', 3, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.1.2', 3, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.9.8', 3, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.2', 4, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 4, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.3', 4, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.7', 4, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.1.2', 4, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.9.8', 4, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.2', 5, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 5, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.3', 5, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.7', 5, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.1.2', 5, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.9.8', 5, 4);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.2', 6, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 6, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.3', 6, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.7', 6, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.1.2', 6, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.9.8', 6, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.2', 7, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 7, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.3', 7, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.7', 7, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.1.2', 7, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.9.8', 7, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.3', 8, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 8, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.5.3', 8, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.4.7', 8, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.5.2', 8, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.4.8', 8, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.3', 9, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 9, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.5.3', 9, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.4.7', 9, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.5.2', 9, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.4.8', 9, 10);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.10.8', 9, 10);

--------------------------------------------------------------------------------

create user software with
  LOGIN
  NOSUPERUSER
  NOINHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION;
  
grant select on SoftwareCheckUpdates to software;