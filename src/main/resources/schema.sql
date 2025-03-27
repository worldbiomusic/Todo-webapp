DROP TABLE IF EXISTS todos;
DROP TABLE IF EXISTS authentications;

CREATE TABLE todos (
    ID serial PRIMARY KEY,
    todo varchar(255) NOT NULL,
    detail text,
    created_at timestamp without time zone,
    updated_at timestamp without time zone
);

CREATE TABLE authentications (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);







