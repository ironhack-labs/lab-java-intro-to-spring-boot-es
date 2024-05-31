package com.example.hospital.repository;

import com.example.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(LocalDate startdate, LocalDate endDate);
    List<Patient> findByAdmittedByDepartament(String departament);
    List<Patient> findByAdmittedByStatus(String status);
}
