package com.ironhack.Lbspring.repository;

import com.ironhack.Lbspring.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(Date startDate, Date endDate);
    List<Patient> findByAdmittedByDepartment(String department);
    List<Patient> findByAdmittedByStatus(String status);

    //List<com.ironhack.Lbspring.model.Patient> findByDate_Of_BirthBetween(Date startDate, Date endDate);
}
