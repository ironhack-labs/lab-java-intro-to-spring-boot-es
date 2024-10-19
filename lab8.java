//Obtener todos los doctores
GET /doctors

//Obtener doctores por ID
GET /doctors/{employee_id}

//Obtener doctores por "status"
GET /doctors/status/{status}

//Obtener medicos por departamento
GET /doctors/department/{department}

//Obtener pacientes
GET /patients

//Obtener pacientes por ID
GET /patients/{patient_id}

//Obtener pacientes por fecha de nacimiento
GET /patients/birthdate?startDate={startDate}&endDate={endDate}

// btener pacientes por el departamento del medico que los admitio
GET /patients/doctor/department/{department}

//Obtener todos los poacientes con un medico cuyo estado sea OFF
GET /patients/doctor/status/OFF

