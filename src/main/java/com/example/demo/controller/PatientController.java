package com.example.demo.controller;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable int id) {
        return patientRepository.findById(id).orElse(null);
    }

    @GetMapping("/date-range")
    // /patients/date-range?firstDate=1954-11-10&secondDate=2000-01-01
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateRange(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate) {
        return patientRepository.findByDateOfBirthBetween(firstDate, secondDate);
    }

    @GetMapping("/admitted-by-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByAdmittedByDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    @GetMapping("/admitted-by-status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByAdmittedByStatus(@PathVariable String status) {
        return patientRepository.findByAdmittedBy_Status(status);
    }

}
