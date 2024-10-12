CREATE TABLE Employee (
                          employee_id INT PRIMARY KEY,
                          department VARCHAR(50),
                          name VARCHAR(100),
                          status VARCHAR(20)
);
CREATE TABLE Patient (
                         patient_id INT PRIMARY KEY,
                         name VARCHAR(100),
                         date_of_birth DATE,
                         admitted_by INT,
                         FOREIGN KEY (admitted_by) REFERENCES Employee(employee_id)
);
INSERT INTO Patient (patient_id, name, date_of_birth, admitted_by) VALUES
(1, 'Jaime Jordan', '1984-03-02', 564134),
(2, 'Marian Garcia', '1972-01-12', 564134),
(3, 'Julia Dusterdieck', '1954-06-11', 356712),
(4, 'Steve McDuck', '1931-11-10', 761527),
(5, 'Marian Garcia', '1999-02-15', 172456);

const express = require('express');
const app = express();
const port = 3000;

// Simulación de conexión a la base de datos
const mockDb = {
  query: (query, params, callback) => {
    // Esta función simula una consulta a la base de datos
    // Desarrolla aquí tu lógica de conexión real a la DB
  }
};

// Obtener todos los médicos
app.get('/doctors', (req, res) => {
  mockDb.query('SELECT * FROM Employee', [], (err, results) => {
    if (err) return res.status(500).send(err);
    res.json(results);
  });
});

// Obtener médico por ID
app.get('/doctors/:id', (req, res) => {
  const { id } = req.params;
  mockDb.query('SELECT * FROM Employee WHERE employee_id = ?', [id], (err, results) => {
    if (err) return res.status(500).send(err);
    res.json(results);
  });
});

// Obtener médicos por estado
app.get('/doctors/status/:status', (req, res) => {
  const { status } = req.params;
  mockDb.query('SELECT * FROM Employee WHERE status = ?', [status], (err, results) => {
    if (err) return res.status(500).send(err);
    res.json(results);
  });
});

// Obtener médicos por departamento
app.get('/doctors/department/:department', (req, res) => {
  const { department } = req.params;
  mockDb.query('SELECT * FROM Employee WHERE department = ?', [department], (err, results) => {
    if (err) return res.status(500).send(err);
    res.json(results);
  });
});

app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});

// Obtener todos los pacientes
app.get('/patients', (req, res) => {
  mockDb.query('SELECT * FROM Patient', [], (err, results) => {
    if (err) return res.status(500).send(err);
    res.json(results);
  });
});

// Obtener paciente por ID
app.get('/patients/:id', (req, res) => {
  const { id } = req.params;
  mockDb.query('SELECT * FROM Patient WHERE patient_id = ?', [id], (err, results) => {
    if (err) return res.status(500).send(err);
    res.json(results);
  });
});

// Obtener pacientes por rango de fecha de nacimiento
app.get('/patients/birthdate', (req, res) => {
  const { start, end } = req.query;
  mockDb.query('SELECT * FROM Patient WHERE date_of_birth BETWEEN ? AND ?', [start, end], (err, results) => {
    if (err) return res.status(500).send(err);
    res.json(results);
  });
});

// Obtener pacientes por departamento del médico que los admitió
app.get('/patients/department/:department', (req, res) => {
  const { department } = req.params;
  const query = `
    SELECT Patient.* FROM Patient
    JOIN Employee ON Patient.admitted_by = Employee.employee_id
    WHERE Employee.department = ?
  `;
  mockDb.query(query, [department], (err, results) => {
    if (err) return res.status(500).send(err);
    res.json(results);
  });
});

// Obtener todos los pacientes con un médico cuyo estado es OFF
app.get('/patients/doctor-status/OFF', (req, res) => {
  const query = `
    SELECT Patient.* FROM Patient
    JOIN Employee ON Patient.admitted_by = Employee.employee_id
    WHERE Employee.status = 'OFF'
  `;
  mockDb.query(query, [], (err, results) => {
    if (err) return res.status(500).send(err);
    res.json(results);
  });
});



