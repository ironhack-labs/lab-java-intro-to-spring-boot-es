package com.ironhack.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironhack.spring.model.Employee;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);



    
}
