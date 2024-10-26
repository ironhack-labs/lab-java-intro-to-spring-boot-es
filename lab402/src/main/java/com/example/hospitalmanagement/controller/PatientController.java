package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // Obtener todos los pacientes
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Obtener paciente por ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    // Obtener pacientes por rango de fecha de nacimiento
    @GetMapping("/dob")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    // Obtener pacientes por departamento del médico que los admitió
    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    // Obtener pacientes con médico cuyo estado es OFF
    @GetMapping("/doctor-status/OFF")
    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientRepository.findByAdmittedBy_Status("OFF");
    }
}
