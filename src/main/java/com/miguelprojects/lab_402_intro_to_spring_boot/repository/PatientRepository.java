package com.miguelprojects.lab_402_intro_to_spring_boot.repository;

import com.miguelprojects.lab_402_intro_to_spring_boot.Enums.Status;
import com.miguelprojects.lab_402_intro_to_spring_boot.model.Employee;
import com.miguelprojects.lab_402_intro_to_spring_boot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDateOfBirthBetween(LocalDate from, LocalDate to);

    @Query(value ="SELECT p FROM Patient p " +
            "INNER JOIN p.doctor e " +
            "WHERE e.department = :department")
    List<Patient> findByDepartmentOfDoctor(@Param("department") String department);


    @Query(value = "SELECT p FROM Patient p " +
            "INNER JOIN p.doctor e " +
            "WHERE e.status = 'OFF'")
    List<Patient> findByDoctorsWithOffStatus();


}
