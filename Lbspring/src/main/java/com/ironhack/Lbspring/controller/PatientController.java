package com.ironhack.Lbspring.controller;

import com.ironhack.Lbspring.model.Patient;
import com.ironhack.Lbspring.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/date-range")
    public List<Patient> getPatientsByDateOfBirthBetween(@RequestParam Date startDate, @RequestParam Date endDate) {
        return patientService.getPatientsByDateOfBirthBetween(startDate, endDate);
    }
}
