-- test data - exec manually after starting the DB containers.
--

-- postgres
CREATE TABLE IF NOT EXISTS users (
    user_id VARCHAR(256) PRIMARY KEY,
    login VARCHAR(256),
    first_name VARCHAR(256),
    last_name VARCHAR(256)
);

INSERT INTO users VALUES ('1', 'login_1', 'Name1', 'Surname1');


-- mysql
CREATE TABLE IF NOT EXISTS user_table (
    ldap_login VARCHAR(256) PRIMARY KEY,
    name VARCHAR(256),
    surname VARCHAR(256)
);
INSERT INTO user_table VALUES ('login_5', 'Name5', 'Surname5');
