CREATE TABLE figlet
(
    id           bigint  NOT NULL
        CONSTRAINT figlet_pkey PRIMARY KEY,
    figlet_value varchar NOT NULL
);

CREATE SEQUENCE figlet_id_seq;