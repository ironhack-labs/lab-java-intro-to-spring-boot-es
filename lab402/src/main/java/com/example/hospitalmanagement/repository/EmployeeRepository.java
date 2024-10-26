package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Method to find employees by status
    List<Employee> findByStatus(String status);

    // Method to find employees by department
    List<Employee> findByDepartment(String department);
}
