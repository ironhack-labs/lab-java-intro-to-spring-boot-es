package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    List<Employee> findAll();

    Optional<Employee> findById(Integer id);

    List<Employee> findByStatus(Status status);

    List<Employee> findByDepartment(String department);
}
