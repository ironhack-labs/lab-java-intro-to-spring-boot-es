package com.ironhack.Lbspring.service;

import com.ironhack.Lbspring.model.Patient;
import com.ironhack.Lbspring.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatientsByDateOfBirthBetween(Date startDate, Date endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }
}
