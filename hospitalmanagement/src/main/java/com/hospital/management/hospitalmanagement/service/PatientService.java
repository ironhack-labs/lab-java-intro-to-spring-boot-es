package com.hospital.management.hospitalmanagement.service;

import com.hospital.management.hospitalmanagement.entity.Employee;
import com.hospital.management.hospitalmanagement.entity.Patient;
import com.hospital.management.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(int id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public List<Patient> getPatientsByDateOfBirthRange(LocalDate start, LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    public List<Patient> getPatientsWithDoctorOff() {
        return patientRepository.findByAdmittedBy_Status(Employee.Status.OFF);
    }
}
