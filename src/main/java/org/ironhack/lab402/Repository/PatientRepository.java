package org.ironhack.lab402.Repository;

import org.ironhack.lab402.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(LocalDate start, LocalDate end);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.department = :department")
    List<Patient> findByDoctorsDepartment(@Param("department") String department);

    @Query("FROM Patient p WHERE p.admittedBy.status = 'OFF'")
    List<Patient> findByDoctorsOffStatus();
}
