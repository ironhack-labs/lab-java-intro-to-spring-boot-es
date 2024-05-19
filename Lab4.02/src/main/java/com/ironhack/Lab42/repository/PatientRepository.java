package com.ironhack.Lab42.repository;

import com.ironhack.Lab42.model.Patient;
import com.ironhack.Lab42.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(Date from, Date to);

    @Query("SELECT p FROM Patient p INNER JOIN p.admittedBy e WHERE e.department = :department")
    List<Patient> findByAdmittedByDepartment(@Param("department") String department);

    @Query("SELECT p FROM Patient p INNER JOIN p.admittedBy e WHERE e.status = :status")
    List<Patient> findByAdmittedByStatus(@Param("status") Status status);
}
