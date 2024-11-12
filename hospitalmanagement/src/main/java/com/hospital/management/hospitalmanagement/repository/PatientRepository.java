package com.hospital.management.hospitalmanagement.repository;

import com.hospital.management.hospitalmanagement.entity.Patient;
import com.hospital.management.hospitalmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(LocalDate start, LocalDate end);
    List<Patient> findByAdmittedBy_Department(String department);
    List<Patient> findByAdmittedBy_Status(Employee.Status status);
}
