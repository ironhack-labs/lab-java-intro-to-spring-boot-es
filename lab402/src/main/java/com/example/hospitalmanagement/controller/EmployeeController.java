package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.entity.Employee;
import com.example.hospitalmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employees by status
    @GetMapping("/status/{status}")
    public List<Employee> getEmployeesByStatus(@PathVariable String status) {
        return employeeRepository.findByStatus(status);
    }

    // Get employees by department
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return employeeRepository.findByDepartment(department);
    }
}
