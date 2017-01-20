/*nom de la base : test*/

drop table mod;
drop table gameversion;


create table gameversion(
	gameversion_id serial,
	gameversion_label varchar(8) not null,
	
	constraint pk_gameversion primary key (gameversion_id)
);

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

create table mod(
	mod_id serial,
	mod_label varchar(50) not null,
	
	mod_uneVersion int,
	
	constraint pk_mod primary key (mod_id),
	constraint fk_mod_uneVersion foreign key (mod_uneVersion) references gameversion (gameversion_id)
		
);

insert into mod (mod_label, mod_uneVersion) values ('industrial craft', 8);