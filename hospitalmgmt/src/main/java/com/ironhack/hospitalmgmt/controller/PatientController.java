package com.ironhack.hospitalmgmt.controller;

import com.ironhack.hospitalmgmt.model.Patient;
import com.ironhack.hospitalmgmt.service.PatientService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @GetMapping("/birthdate-range")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return patientService.findByDateOfBirthRange(start, end);
    }

    @GetMapping("/admitted-by-department/{department}")
    public List<Patient> getPatientsByAdmittedByDepartment(@PathVariable String department) {
        return patientService.findByAdmittedByDepartment(department);
    }

    @GetMapping("/admitted-by-status/{status}")
    public List<Patient> getPatientsByAdmittedByStatus(@PathVariable String status) {
        return patientService.findByAdmittedByStatus(status);
    }
}