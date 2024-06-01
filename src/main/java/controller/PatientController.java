package com.ironhack.hospital.controller;

import com.ironhack.hospital.model.Patient;
import com.ironhack.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @GetMapping("/dob-range")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam String startDate, @RequestParam String endDate) {
        return patientRepository.findByDateOfBirthBetween(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/doctor-status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable String status) {
        return patientRepository.findByAdmittedByStatus(status);
    }
}
