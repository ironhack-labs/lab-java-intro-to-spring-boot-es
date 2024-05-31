package com.example.hospital.repository;

import com.example.hospital.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> finfByStatus(String status);
    List<Employee> findByDepartment(String department);
}
