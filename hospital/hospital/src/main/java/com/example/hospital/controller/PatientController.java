package com.example.hospital.controller;

import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/dob")
    public List<Patient> getPatientByDateOfBirthRange(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientService.getPatientByDBirthRange(startDate, endDate);
    }
    @GetMapping("/doctor-department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }
    @GetMapping("/doctor-status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable String status) {
        return patientService.getPatientsByDoctorStatus(status);
    }
}
