package com.ironhack.Lab42.repository;

import com.ironhack.Lab42.model.Employee;
import com.ironhack.Lab42.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);
}
