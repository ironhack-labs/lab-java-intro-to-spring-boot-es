package org.alvarowau.repository;

import org.alvarowau.model.Patient;
import org.alvarowau.model.enums.StatusEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Encontrar pacientes por rango de fecha de nacimiento
    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    // Encontrar pacientes por departamento del médico que los admitió
    List<Patient> findByEmployeeDepartment(String department);

    // Encontrar pacientes cuyo médico tiene el estado "OFF"
    List<Patient> findByEmployeeStatus(StatusEmployee status);
}
