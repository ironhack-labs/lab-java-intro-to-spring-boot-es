package com.miguelprojects.lab_402_intro_to_spring_boot.repository;

import com.miguelprojects.lab_402_intro_to_spring_boot.Enums.Status;
import com.miguelprojects.lab_402_intro_to_spring_boot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);

}
