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
	modversion_date date,
	
	modversion_unmod int,
	modversion_uneversion int,
	
	constraint pk_modversion primary key (modversion_id),
	constraint fk_unmod foreign key (modversion_unmod) references mod (mod_id),
	constraint fk_modversion_uneversion foreign key (modversion_uneversion) references gameversion (gameversion_id)
);

create table modpack(
	modpack_id serial,
	modpack_label varchar(50) not null,
	
	constraint pk_modpack primary key (modpack_id),
	constraint unique_modpack_label unique (modpack_label)
		
);


create table modpackversion(
	modpackversion_id serial,
	modpackversion_label varchar(20) not null,
	modpackversion_date date,
	
	modpackversion_unmodpack int,
	modpackversion_uneversion int,
	
	constraint pk_modpackversion primary key (modpackversion_id),
	constraint fk_unmodpack foreign key (modpackversion_unmodpack) references modpack (modpack_id),
	constraint fk_modpackversion_uneversion foreign key (modpackversion_uneversion) references gameversion (gameversion_id)
);

create table texturepack(
	texturepack_id serial,
	texturepack_label varchar(50) not null,
	
	constraint pk_texturepack primary key (texturepack_id),
	constraint unique_texturepack_label unique (texturepack_label)
		
);


create table texturepackversion(
	texturepackversion_id serial,
	texturepackversion_label varchar(20) not null,
	texturepackversion_date date,
	
	texturepackversion_untexturepack int,
	texturepackversion_uneversion int,
	
	constraint pk_texturepackversion primary key (texturepackversion_id),
	constraint fk_untexturepack foreign key (texturepackversion_untexturepack) references texturepack (texturepack_id),
	constraint fk_texturepackversion_uneversion foreign key (texturepackversion_uneversion) references gameversion (gameversion_id)
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
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.1.2', 1, 2);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.2', 1, 2);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.3', 1, 2);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('1.2.7', 1, 2);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.1.2', 1, 2);
insert into modversion (modversion_label, modversion_unMod, modversion_uneVersion) values ('2.9.8', 1, 2);
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


insert into texturepack (texturepack_label) values ('Faithful');
insert into texturepack (texturepack_label) values ('Smoothcraft');

insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('1.1.2', 1, 1, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('1.2.2', 1, 1, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('1.2.3', 1, 1, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('1.2.7', 1, 1, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('2.1.2', 1, 1, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('2.9.8', 1, 1, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('1.1.2', 2, 2, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('1.2.2', 2, 2, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('1.2.3', 2, 2, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('1.2.7', 2, 2, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('2.1.2', 2, 2, '2017-06-01');
insert into texturepackversion (texturepackversion_label, texturepackversion_untexturepack, texturepackversion_uneVersion, texturepackversion_date) values ('2.9.8', 2, 2, '2017-06-01');
--------------------------------------------------------------------------------

create user software with
  LOGIN
  NOSUPERUSER
  NOINHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION;
  
grant select on SoftwareCheckUpdates to software;