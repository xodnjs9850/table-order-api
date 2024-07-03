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
    refresh_token VARCHAR(255) DEFAULT NULL,
    last_token_issued_at DATETIME(6) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY users_email_unique (email),
    INDEX idx_users_email (email),
    INDEX idx_users_name (name)
);

-- Create restaurants table
CREATE TABLE IF NOT EXISTS restaurants (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    userID VARCHAR(255) NOT NULL
);

-- Create menus table
CREATE TABLE IF NOT EXISTS menus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    restaurant_id INT NOT NULL,
    price INT NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

-- Create menus table
CREATE TABLE IF NOT EXISTS menus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    restaurant_id INT NOT NULL,
    price INT NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

-- Create menu Info table
CREATE TABLE IF NOT EXISTS information (
    id INT AUTO_INCREMENT PRIMARY KEY,
    comment VARCHAR(255) NOT NULL,
    menu_id INT NOT NULL,
    FOREIGN KEY (menu_id) REFERENCES menus(id)
);

-- Create orders table
CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    basket VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    restaurant_id INT NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);
