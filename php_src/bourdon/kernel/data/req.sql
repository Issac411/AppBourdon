CREATE TABLE secteur_activite(
  id SERIAL,
  libelle varchar(255) NOT NULL,
  CONSTRAINT pk_secteur_activite PRIMARY KEY (id)
);