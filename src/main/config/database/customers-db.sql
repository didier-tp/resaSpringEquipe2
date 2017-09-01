


--CREATE DATABASE customers;

-- DROP TABLES
DROP TABLE IF EXISTS public.escale;
DROP TABLE IF EXISTS public.compagnie_vol;
DROP TABLE IF EXISTS public.passager;
DROP TABLE IF EXISTS public.reservation;
DROP TABLE IF EXISTS public.vol;
DROP TABLE IF EXISTS public.villeaeroport;
DROP TABLE IF EXISTS public.aeroport;
DROP TABLE IF EXISTS public.client;
DROP TABLE IF EXISTS public.compagnie;
DROP TABLE IF EXISTS public.compagnieaeriennevol;
DROP TABLE IF EXISTS public.compagnieaerienne;
DROP TABLE IF EXISTS public.login;
DROP TABLE IF EXISTS public.ville;




-- Creation des tables
-- Table AEROPORT
CREATE TABLE public.aeroport
(
  id_aeroport SERIAL NOT NULL,
  nom_aeroport character varying(100),
  version_aeroport integer,
  CONSTRAINT aeroport_pkey PRIMARY KEY (id_aeroport)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.aeroport
  OWNER TO postgres;
  -- Table CLIENT
  CREATE TABLE public.client
(
  type character varying(8) NOT NULL,
  id_client SERIAL NOT NULL,
  cp_client character varying(5),
  pays_client character varying(150),
  rue_client character varying(255),
  ville_client character varying(150),
  email_client character varying(150),
  nom_client character varying(150),
  numero_fax_client integer,
  numero_tel_client integer,
  version_client integer,
  prenom_client_physique character varying(255),
  titre_physique integer,
  siret_client character varying(255),
  titre_moral integer,
  CONSTRAINT client_pkey PRIMARY KEY (id_client)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.client
  OWNER TO postgres;  
  -- Table COMPAGNIE
  CREATE TABLE public.compagnie
(
  compagnie_id SERIAL NOT NULL,
  nom_compagnie character varying(255),
  version_compagnie integer,
  CONSTRAINT compagnie_pkey PRIMARY KEY (compagnie_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.compagnie
  OWNER TO postgres;  
    -- Table VOL 
  CREATE TABLE public.vol
(
  id_vol SERIAL NOT NULL,
  date_arrivee_vol date,
  date_depart_vol date,
  heure_arrivee_vol time without time zone,
  heure_depart_vol time without time zone,
  version_vol integer,
  id_aeroport_arrivee_vol bigint NOT NULL,
  id_aeroport_depart_vol bigint NOT NULL,
  CONSTRAINT vol_pkey PRIMARY KEY (id_vol),
  CONSTRAINT fk2f5j075qbxuehd4qyhjb2f50e FOREIGN KEY (id_aeroport_arrivee_vol)
      REFERENCES public.aeroport (id_aeroport) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fklxdumtcsto4w4r5sycpwshvfo FOREIGN KEY (id_aeroport_depart_vol)
      REFERENCES public.aeroport (id_aeroport) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.vol
  OWNER TO postgres;
  -- Table COMPAGNIE_VOL
  CREATE TABLE public.compagnie_vol
(
  version_compagnie_vol integer,
  compagnie_id bigint NOT NULL,
  vol_id bigint NOT NULL,
  CONSTRAINT compagnie_vol_pkey PRIMARY KEY (compagnie_id, vol_id),
  CONSTRAINT fk4lufnqn8d4mc3l6u06hah8vr3 FOREIGN KEY (vol_id)
      REFERENCES public.vol (id_vol) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkpqvd8t6drt9j4xpc25n9m6ky FOREIGN KEY (compagnie_id)
      REFERENCES public.compagnie (compagnie_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.compagnie_vol
  OWNER TO postgres;
  -- Table COMPAGNIEAERIENNE
  CREATE TABLE public.compagnieaerienne
(
  compagnie_id SERIAL NOT NULL,
  nom character varying(30) NOT NULL,
  CONSTRAINT compaer_compagnie_id PRIMARY KEY (compagnie_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.compagnieaerienne
  OWNER TO postgres;
  -- Table COMPAGNIEAERIENNEVOL
  CREATE TABLE public.compagnieaeriennevol
(
  compagnie_id integer,
  vol_id integer,
  numero_vol character varying(20) NOT NULL,
  CONSTRAINT compaervol_compagnie_fk FOREIGN KEY (compagnie_id)
      REFERENCES public.compagnieaerienne (compagnie_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.compagnieaeriennevol
  OWNER TO postgres;
  -- Table ESCALE
  CREATE TABLE public.escale
(
  heurearrivee_escale date,
  heuredepart_escale date,
  version_escale integer,
  id_aeroport bigint NOT NULL,
  id_vol bigint NOT NULL,
  CONSTRAINT escale_pkey PRIMARY KEY (id_aeroport, id_vol),
  CONSTRAINT fk9c3jjxj2jea83p4e8ck49qif8 FOREIGN KEY (id_vol)
      REFERENCES public.vol (id_vol) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkq6jxe9ut24vgy4mifyprr861v FOREIGN KEY (id_aeroport)
      REFERENCES public.aeroport (id_aeroport) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.escale
  OWNER TO postgres;
  -- Table LOGIN
  CREATE TABLE public.login
(
  id_login integer NOT NULL,
  admin_login boolean,
  login character varying(255),
  mot_de_passe_login character varying(255),
  version_login integer,
  CONSTRAINT login_pkey PRIMARY KEY (id_login)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.login
  OWNER TO postgres;
    -- Table RESERVATION
  CREATE TABLE public.reservation
(
  id_reservation SERIAL NOT NULL,
  date_de_reservation date,
  numero_de_reservation integer,
  version_reservation integer,
  id_client_reservation bigint NOT NULL,
  id_vol_reservation bigint NOT NULL,
  CONSTRAINT reservation_pkey PRIMARY KEY (id_reservation),
  CONSTRAINT fk2xgfy0knlmpt7k8xnhy2tgpro FOREIGN KEY (id_vol_reservation)
      REFERENCES public.vol (id_vol) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fksv9kuhf2s4mq7v0fdhe97g2i FOREIGN KEY (id_client_reservation)
      REFERENCES public.client (id_client) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.reservation
  OWNER TO postgres;
  -- Table PASSAGER
  CREATE TABLE public.passager
(
  id_passager SERIAL NOT NULL,
  cp_passager character varying(5),
  pays_passager character varying(150),
  rue_passager character varying(255),
  ville_passager character varying(150),
  nom_passager character varying(150),
  prenom_passager character varying(150),
  version_passager integer,
  id_reservation_passager bigint,
  CONSTRAINT passager_pkey PRIMARY KEY (id_passager),
  CONSTRAINT fk4mug7swvcqyg6ocylmum07isg FOREIGN KEY (id_reservation_passager)
      REFERENCES public.reservation (id_reservation) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.passager
  OWNER TO postgres;

  -- Table VILLE
  CREATE TABLE public.ville
(
  id_ville SERIAL NOT NULL,
  nom_ville character varying(100),
  version_ville integer,
  CONSTRAINT ville_pkey PRIMARY KEY (id_ville)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.ville
  OWNER TO postgres;
  -- Table VILLEAEROPORT
  CREATE TABLE public.villeaeroport
(
  version_villeaeroport integer,
  id_aeroport bigint NOT NULL,
  id_ville bigint NOT NULL,
  CONSTRAINT villeaeroport_pkey PRIMARY KEY (id_aeroport, id_ville),
  CONSTRAINT fk8k1ao0l1f7s78pgant2relpum FOREIGN KEY (id_aeroport)
      REFERENCES public.aeroport (id_aeroport) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkp4qc1wwlp1pohjc2yfpn7n61o FOREIGN KEY (id_ville)
      REFERENCES public.ville (id_ville) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.villeaeroport
  OWNER TO postgres;

     

  
  
-- INIT VALUES
INSERT INTO Client(type,cp_client , pays_client , rue_client , ville_client,email_client,nom_client,numero_fax_client
,numero_tel_client,prenom_client_physique,titre_physique,siret_client,titre_moral,version_client) 
   VALUES ('physique','75000 ' , 'france' , 'rue rougemont' , 'paris','aa@bb.cc','therieur','11','2','alain','0','0','0','0'),
   ('physique','75000 ' , 'france' , 'rue rougemont' , 'paris','aa@bb.cc','therieur','11','2','alex','0','0','0','0');
   
   INSERT INTO Login( id_login ,  admin_login ,  login ,  mot_de_passe_login  ,  version_login ) 
   VALUES ('1','0','alex','pwdalex','0');
   
   INSERT INTO Ville( nom_ville  ,  version_ville )
   VALUES ('paris','0');
   
  



