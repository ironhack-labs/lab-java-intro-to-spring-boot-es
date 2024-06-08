package com.ironhack.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ironhack.spring.model.Patient;
import com.ironhack.spring.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable Long patientId) {
        return patientService.getPatientById(patientId);
    }

    @GetMapping("/dob")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateOfBirth(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return patientService.getPatientsByDateOfBirth(startDate, endDate);
    }

    @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    List<Patient> findByAdmittedByDepartment(@PathVariable String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }
}
