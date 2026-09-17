CREATE DATABASE IF NOT EXISTS studentdb;

USE studentdb;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    marks DOUBLE
);
