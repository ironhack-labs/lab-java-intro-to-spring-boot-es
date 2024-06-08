package com.ironhack.spring.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironhack.spring.model.Patient;
import com.ironhack.spring.repository.PatientRepository;

/**
 * PatientService
 */
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    public List<Patient> getPatientsByDateOfBirth(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    public List<Patient> getPatientsByDoctorStatus(String status) {
        return patientRepository.findByAdmittedByStatus(status);
    }
}
