create TEXT table PRODUIT(
	id_article integer,
	nom varchar(20) not null,
	prix double not null
) ;
SET TABLE PRODUIT SOURCE "PRODUIT;fs=|"

create TEXT table client(
	id_client integer,
	nom varchar(20) not null,
) ;

create TEXT table facture(
	num_cmd integer,
	date_facture date,
	id_client integer not null,
) ;


create TEXT table commande(
	num_cmd integer,
	id_article integer,
	nombre integer not null
) ;

alter table produit add primary key (id_article);
alter table client add primary key (id_client);
alter table facture add primary key (num_cmd);
alter table commande add primary key (num_cmd, id_article);

alter table facture add foreign key (id_client) references client;
alter table commande add foreign key (id_article) references article;
alter table commande add foreign key (num_cmd) references facture;

CREATE SEQUENCE facture_sequence START WITH 1 INCREMENT BY 1