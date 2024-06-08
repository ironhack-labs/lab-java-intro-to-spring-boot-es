-- Create the schema if it doesn't exist
CREATE SCHEMA IF NOT EXISTS springdb;

-- Use the schema
USE springdb;

-- Drop the tables if they already exist
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS employees;

-- Create the employees table
CREATE TABLE IF NOT EXISTS employees (
    employee_id INT NOT NULL,
    department VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    status VARCHAR(100) NOT NULL,
    PRIMARY KEY (employee_id)
);

-- Create the patients table
CREATE TABLE IF NOT EXISTS patients (
    patient_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    admitted_by INT NOT NULL,
    PRIMARY KEY (patient_id),
    FOREIGN KEY (admitted_by) REFERENCES employees(employee_id)
);

-- Insert data into employees table
INSERT INTO employees (employee_id, department, name, status) VALUES
(356712, 'cardiology', 'Alonso Flores', 'ON_CALL'),
(564134, 'immunology', 'Sam Ortega', 'ON'),
(761527, 'cardiology', 'German Ruiz', 'OFF'),
(166552, 'pulmonary', 'Maria Lin', 'ON'),
(156545, 'orthopaedic', 'Paolo Rodriguez', 'ON_CALL'),
(172456, 'psychiatric', 'John Paul Armes', 'OFF');

-- Insert data into patients table
INSERT INTO patients (patient_id, name, date_of_birth, admitted_by) VALUES
(1, 'Jaime Jordan', '1984-03-02', 564134),
(2, 'Marian Garcia', '1972-01-12', 564134),
(3, 'Julia Dusterdieck', '1954-06-11', 356712),
(4, 'Steve McDuck', '1931-11-10', 761527),
(5, 'Marian Garcia', '1999-02-15', 172456);
