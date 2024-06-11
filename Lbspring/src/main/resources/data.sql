CREATE TABLE IF NOT EXISTS employee (
                                        employee_id BIGINT PRIMARY KEY,
                                        department VARCHAR(255) NOT NULL,
                                        name VARCHAR(255) NOT NULL,
                                        status VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS patient (
                                       patient_id BIGINT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
                                       date_of_birth DATE NOT NULL,
                                       admitted_by BIGINT,
                                       FOREIGN KEY (admitted_by) REFERENCES employee(employee_id)
);

INSERT INTO employee (employee_id, department, name, status) VALUES
                                                                 (356712, 'cardiology', 'Alonso Flores', 'ON_CALL'),
                                                                 (564134, 'immunology', 'Sam Ortega', 'ON'),
                                                                 (761527, 'cardiology', 'German Ruiz', 'OFF'),
                                                                 (166552, 'pulmonary', 'Maria Lin', 'ON'),
                                                                 (156545, 'orthopaedic', 'Paolo Rodriguez', 'ON_CALL'),
                                                                 (172456, 'psychiatric', 'John Paul Armes', 'OFF');

INSERT INTO patient (patient_id, name, date_of_birth, admitted_by) VALUES
                                                                       (1, 'Jaime Jordan', '1984-03-02', 564134),
                                                                       (2, 'Marian Garcia', '1972-01-12', 564134),
                                                                       (3, 'Julia Dusterdieck', '1954-06-11', 356712),
                                                                       (4, 'Steve McDuck', '1931-11-10', 761527),
                                                                       (5, 'Marian Garcia', '1999-02-15', 172456);
