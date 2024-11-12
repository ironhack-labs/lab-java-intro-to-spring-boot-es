package com.hospital.management.hospitalmanagement.repository;

import com.hospital.management.hospitalmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(Employee.Status status);
    List<Employee> findByDepartment(String department);
}
