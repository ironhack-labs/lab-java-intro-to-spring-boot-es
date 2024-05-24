package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Override
    List<Patient> findAll();

    Optional<Patient> findById (Integer id);

    List<Patient> findByDateOfBirthBetween(LocalDate firstDate, LocalDate secondDate);

    List<Patient> findByAdmittedBy_Department(String department);

    List<Patient> findByAdmittedBy_Status(String status);
}
