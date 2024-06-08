package com.ironhack.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ironhack.spring.model.Employee;
import com.ironhack.spring.model.Patient;

/**
 * PatientRepository
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {



    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
    List<Patient> findByAdmittedBy(Employee employee);


    @Query("SELECT p FROM Patient p WHERE p.admittedBy.department = :department")
    List<Patient> findByAdmittedByDepartment(String department);


    @Query("SELECT p FROM Patient p WHERE p.admittedBy.status = :status")
    List<Patient> findByAdmittedByStatus(String status);
}
