package com.hospital.management.hospitalmanagement.controller;

import com.hospital.management.hospitalmanagement.entity.Patient;
import com.hospital.management.hospitalmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    // Obtener todos los pacientes
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Obtener paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    // Obtener pacientes por rango de fecha de nacimiento
    @GetMapping("/date-of-birth")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return patientService.getPatientsByDateOfBirthRange(start, end);
    }

    // Obtener pacientes por departamento del médico que los admitió
    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }

    // Obtener todos los pacientes con un médico cuyo estado es OFF
    @GetMapping("/doctor-status/OFF")
    public List<Patient> getPatientsWithDoctorOff() {
        return patientService.getPatientsWithDoctorOff();
    }
}

