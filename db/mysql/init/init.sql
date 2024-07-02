-- create the databases
CREATE DATABASE IF NOT EXISTS tableOrderDB;

-- create the tables
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    encrypted_password VARCHAR(255),
    name VARCHAR(255),
    user_role int,
    created_at DATETIME(6) DEFAULT NOW(6),
    PRIMARY KEY (id),
    UNIQUE KEY users_email_unique (email),
    INDEX idx_users_email (email),
    INDEX idx_users_name (name)
);
