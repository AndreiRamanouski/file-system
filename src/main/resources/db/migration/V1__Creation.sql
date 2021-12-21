--drop trigger if exists move_file on files;
--drop table if exists files;
--drop function if exists archive_function();
--drop table if exists archive;
--drop table if exists employees;
--drop table if exists roles;
--drop table if exists flyway_schema_history;


CREATE TABLE IF NOT EXISTS roles(
    id INT NOT NULL PRIMARY KEY ,
    role VARCHAR(10) NOT NULL,
    UNIQUE (id,role)
);

CREATE TABLE IF NOT EXISTS employees
(
    id        SERIAL PRIMARY KEY,
    user_id VARCHAR(30) NOT NULL ,
    email VARCHAR(120) NOT NULL,
    encrypted_password VARCHAR(255) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    first_name VARCHAR(32) NOT NULL,
    role_id INT REFERENCES roles(id) NOT NULL
);


CREATE TABLE IF NOT EXISTS files
(
    id              SERIAL PRIMARY KEY,
    file_id VARCHAR(30),
    date_of_signing DATE         NOT NULL,
    company_name    VARCHAR(64)  NOT NULL,
    content         VARCHAR(256) NOT NULL,
    employee_id     INT          REFERENCES employees (id) ON DELETE SET NULL,
    due_date        DATE         NOT NULL
);


--archive table
CREATE TABLE IF NOT EXISTS archive AS TABLE files WITH NO DATA;

--function
CREATE OR REPLACE FUNCTION archive_function() RETURNS TRIGGER AS
$$
BEGIN

    INSERT INTO archive
    VALUES ((old).*);
    RETURN old;
end;
$$ LANGUAGE plpgsql;

--trigger
CREATE TRIGGER move_file
    BEFORE DELETE
    ON files
    FOR EACH ROW
EXECUTE PROCEDURE archive_function();

--indexes

CREATE INDEX employees_userId_index ON employees(user_id);
CREATE INDEX files_fileId_index ON files(file_id);
