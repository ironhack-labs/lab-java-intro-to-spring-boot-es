package org.amazon.lab4_02.Repositorio;

import org.amazon.lab4_02.Model.Patient;
import org.amazon.lab4_02.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

   List<Patient> findAllByDateOfBirthBetween(LocalDate date, LocalDate date2);

   List<Patient> findAllByAdmittedBy_department(String admitted_department);

   List<Patient> findByAdmittedBy_status_(Status admitted_status);

//   @Query(value = "SELECT Patient.name, Employee.department FROM Patient INNER JOIN Employee ON  Patient.admitted_by= Employee.employeeId WHERE department LIKE 'cardiology'",nativeQuery = true)
//   List<Patient> findAllByDepartment(@Param("department") String department1);



}


