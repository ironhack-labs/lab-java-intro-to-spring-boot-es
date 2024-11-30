package com.miguelprojects.lab_402_intro_to_spring_boot.controller;

import com.miguelprojects.lab_402_intro_to_spring_boot.model.Employee;
import com.miguelprojects.lab_402_intro_to_spring_boot.model.Patient;
import com.miguelprojects.lab_402_intro_to_spring_boot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;



//    Obtener todos los pacientes: Crear una ruta para obtener todos los pacientes.
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

//    Obtener paciente por ID: Crear una ruta para obtener un paciente por patient_id.
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).get();
    }

//    Obtener pacientes por rango de fecha de nacimiento: Crear una ruta para obtener pacientes con fecha de nacimiento dentro de un rango especificado.
    @GetMapping("/dateOfBirth")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientByDateOfBirth(@RequestParam LocalDate dateOfBirthFrom, @RequestParam LocalDate dateOfBirthTo) {
        return patientRepository.findByDateOfBirthBetween(dateOfBirthFrom, dateOfBirthTo);
    }

//    Obtener pacientes por departamento del médico que los admitió: Crear una ruta para obtener
//    pacientes por el departamento en el que se encuentra el médico que los admitió
//    (por ejemplo, obtener todos los pacientes admitidos por un médico en cardiología).
    @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientByDepartment(@PathVariable String department) {
        return patientRepository.findByDepartmentOfDoctor(department);
    }

//    Obtener todos los pacientes con un médico cuyo estado es OFF: Crear una ruta para
//    obtener todos los pacientes con un médico cuyo status sea OFF.
    @GetMapping("/offStatus")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientByOffStatus() {
        return patientRepository.findByDoctorsWithOffStatus();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
}

