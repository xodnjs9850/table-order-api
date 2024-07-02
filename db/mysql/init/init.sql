-- create the databases
CREATE DATABASE IF NOT EXISTS tableOrderDB;

-- create the tables
CREATE TABLE IF NOT EXISTS users (
    id int NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    encrypted_password VARCHAR(255),
    name VARCHAR(255),
    user_role int,
    created_at DATETIME,
    PRIMARY KEY (id),
    UNIQUE KEY users_email_unique (email),
    INDEX idx_users_email (email),
    INDEX idx_users_name (name)
);
