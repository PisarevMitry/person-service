CREATE SEQUENCE log_seq;
CREATE TABLE log
(
    id          BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('log_seq'),
    create_dttm TIMESTAMP,
    method_name VARCHAR,
    class_name  VARCHAR,
    user_name   VARCHAR
);