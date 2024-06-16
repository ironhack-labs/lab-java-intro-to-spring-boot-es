* Obtener todos los médicos
* Solución: http://localhost:8080/employees


* Obtener médico por ID
* Solución: http://localhost:8080/employees/id/166552


* Obtener médicos por estado (status)
* Solución: http://localhost:8080/employees/status/off


* Obtener médicos por departamento
* Solución: http://localhost:8080/employees/department/pulmonary


* Obtener todos los pacientes
* Solución: http://localhost:8080/patients


* Obtener paciente por ID
* Solución: http://localhost:8080/patients/patientId/2


* Obtener pacientes por rango de fecha de nacimiento
* Solución: http://localhost:8080/patients/dateOfBirthBetween?startDate=1980-01-01&endDate=1990-01-01


* Obtener pacientes por departamento del médico que los admitió 
* Solución: http://localhost:8080/patients/admittedBy/psychiatric


* Obtener todos los pacientes con un médico cuyo estado es OFF
* Solución: http://localhost:8080/patients/doctor/status/off