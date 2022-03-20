CREATE SEQUENCE contact_seq;
CREATE TABLE contact
(
    id           BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('contact_seq'),
    phone_number VARCHAR(32)        NOT NULL,
    email        VARCHAR(128) UNIQUE,
    profile_link TEXT UNIQUE
);

CREATE SEQUENCE medical_card_seq;
CREATE TABLE medical_card
(
    id            BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('medical_card_seq'),
    client_status CHAR,
    med_status    CHAR,
    registry_dt   DATE               NOT NULL,
    comment       TEXT
);


CREATE SEQUENCE illness_seq;
CREATE TABLE illness
(
    id              BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('illness_seq'),
    medical_card_id BIGINT             NOT NULL,
    type_id         BIGINT,
    heaviness       CHAR,
    appearance_dttm TIMESTAMP          NOT NULL,
    recovery_dt     DATE,
    FOREIGN KEY (medical_card_id) REFERENCES medical_card (id)
);


CREATE SEQUENCE address_seq;
CREATE TABLE address
(
    id         BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('address_seq'),
    contact_id BIGINT             NOT NULL,
    country_id BIGINT             NOT NULL,
    city       VARCHAR(255)       NOT NULL,
    index      INTEGER,
    street     VARCHAR(255)       NOT NULL,
    building   VARCHAR(32)        NOT NULL,
    flat       VARCHAR(32),
    FOREIGN KEY (contact_id) REFERENCES contact (id)
);

CREATE SEQUENCE person_data_seq;
CREATE TABLE person_data
(
    id              BIGINT PRIMARY KEY NOT NULL DEFAULt nextval('person_data_seq'),
    last_name       VARCHAR(255)       NOT NULL,
    first_name      VARCHAR(255)       NOT NULL,
    birth_dt        DATE               NOT NULL,
    age             SMALLINT,
    sex             CHAR               NOT NULL,
    contact_id      BIGINT             NOT NULL,
    medical_card_id BIGINT             NOT NULL UNIQUE,
    parent_id       BIGINT,
    FOREIGN KEY (contact_id) REFERENCES contact (id),
    FOREIGN KEY (medical_card_id) REFERENCES medical_card (id),
    FOREIGN KEY (parent_id) REFERENCES person_data (id)
);