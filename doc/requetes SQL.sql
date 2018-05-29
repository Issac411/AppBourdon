

/*
Fin Avril
L'entreprise et ses informations, chaque entreprise possède son unique interlocuteur

*/
create table company(
    id int AUTO_INCREMENT,
    name varchar(500) NOT NULL,
    address1 varchar(500) NOT NULL,
    address2 varchar(500),
    pc int,
    num varchar(11),
    fax int,
    interName varchar(200) NOT NULL DEFAULT 'aucun',
    interNickName varchar(200) NOT NULL DEFAULT '',
    interNum varchar(11),
    interFax varchar(11),
    CONSTRAINT pk_company PRIMARY KEY (id)
);


/*
Fin Avril
Le secteur d'activité, une entreprise peut en possèder plusieurs

*/
create table specialisation (
    id int AUTO_INCREMENT,
    libelle varchar(500) NOT NULL,
    code varchar(200),
    CONSTRAINT pk_specialisation PRIMARY KEY (id)
);

/*
Fin Avril
L'importance d'une visite

*/
create table importance (
    id int AUTO_INCREMENT,
    content varchar(500) NOT NULL,
    CONSTRAINT pk_importance PRIMARY KEY (id)
);

/*
Fin Avril
Une visite, on prend en compte sa durée, on peut y ajouter un commentaire et savoir si elle est en cours, finie, annulée.

*/
create table entry(
    id int AUTO_INCREMENT,
    idCompany int,
    idCommercial,
    date timestamp NOT NULL,
    comment varchar(500) NOT NULL,
    duration int NOT NULL, /* en minutes*/
    status varchar(300),
    CONSTRAINT pk_entry PRIMARY KEY (id),
    CONSTRAINT fk_idCompany FOREIGN KEY (idCompany) REFERENCES company (id),
    CONSTRAINT fk_idCommercial FOREIGN KEY (idCommercial) REFERENCES commercial (id),
);

/*
Fin Avril
Le commercial et ses informations personnelles

*/
create table commercial(
    id int AUTO_INCREMENT,
    nickName varchar(500) NOT NULL,
    name varchar(500) NOT NULL,
    address1 varchar(500) NOT NULL,
    address2 varchar(500) NOT NULL,
    pc int NOT NULL,
    city varchar(500) NOT NULL,
    CONSTRAINT pk_commercial PRIMARY KEY (id)
);

/*
Fin Avril
Pour savoir quelle entreprise réalise quelle type d'activité, NM

*/
create table practiced (
    id int AUTO_INCREMENT,
    idSpecialiation int,
    idCompany int,
    CONSTRAINT fk_idSpecialisation FOREIGN KEY (idSpecialiation) REFERENCES specialisation (id),
    CONSTRAINT fk_idCompany FOREIGN KEY (idCompany) REFERENCES company (id),
    CONSTRAINT pk_practiced PRIMARY KEY (id)

);

/*
Fin Avril
Exemple de requetes pour l'ajout de commerciaux

*/
insert into commercial (name,nickName,address1,address2,city,pc) VALUES ('Sam','Bob','Rue Ferret','Porte 2','Paris',75000);
insert into commercial (name,nickName,address1,address2,city,pc) VALUES ('Pierre','Desjeans','Carrefour de Paris','Rue du réseau','Lyon',69000);
insert into commercial (name,nickName,address1,address2,city,pc) VALUES ('Henry','Quatre','4ème rue','Sous-sol 1', 'Cité des nombres',45751);
insert into commercial (name,nickName,address1,address2,city,pc) VALUES ('Paul','LeChauve','Rue des coiffeurs','Coiffe sur crâne',45751);
insert into commercial (name,nickName,address1,address2,city,pc) VALUES ('Pauline','Serviet','Impasse Montargis','Porte 8',"Orléans",45751);




