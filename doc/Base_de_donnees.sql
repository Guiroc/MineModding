create table gameversion(
	id int,
	label varchar(8)
	
	constraint pk_gameversion primary key (id)
);
	
create table mod(
	id int,
	label varchar(50),
	
	uneVersion int,
	
	constraint pk_mod primary key (id),
	constraint fk_uneVersion foreing key (uneVersion) references gameversion (id)
);

create table modversion(
	id int,
	version varchar(20),
	
	unMod int,
	
	constraint pk_modversion primary key (id),
	constraint fk_unMod foreign key (unMod) references mod (id)
);

create table modspack(
	id int,
	label varchar(50),
	
	constraint pk_modspack primary key (id),
);

create table modspackversion(
	id int,
	
	unModspackversion int,
	uneVersion int,
	
	constraint pk_modspackversion primary key (id),
	constraint fk_unModspackversion foreign key (unModspackversion) references modspack (id),
	constraint fk_uneVersion foreign key (uneVersion) references gameversion (id),
);

create table profile(
	id int,
	label varchar(50),
	
	uneVersion int,
	unModspackversionversion int,
	
	constraint pk_profile primary key (id),
	constraint fk_uneVersion foreign key (uneVersion) references gameversion (id),
	constraint fk_modspackversion foreign key (unModspackversionVersion) references modspackversion (id)
);
