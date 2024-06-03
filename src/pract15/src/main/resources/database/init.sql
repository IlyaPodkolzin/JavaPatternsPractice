CREATE TABLE IF NOT EXISTS authors
(
    id SERIAL NOT NULL PRIMARY KEY ,
    first_name VARCHAR,
    last_name VARCHAR,
    middle_name VARCHAR,
    birth_date VARCHAR
);

CREATE TABLE IF NOT EXISTS books
(
    id SERIAL NOT NULL PRIMARY KEY ,
    name VARCHAR,
    creation_date VARCHAR
)