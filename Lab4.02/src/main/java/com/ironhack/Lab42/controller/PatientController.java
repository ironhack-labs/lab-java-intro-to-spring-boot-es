package com.ironhack.Lab42.controller;

import com.ironhack.Lab42.model.Employee;
import com.ironhack.Lab42.model.Patient;
import com.ironhack.Lab42.model.Status;
import com.ironhack.Lab42.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

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

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable(name = "id") Integer patientId) {
        return patientRepository.findById(patientId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
    }

    @GetMapping("/dob")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsBetweenDates(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                                 @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByAdmittedByDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsWithDoctorOffStatus(@PathVariable String status) {
        return patientRepository.findByAdmittedByStatus(Status.valueOf(status));
    }

}
