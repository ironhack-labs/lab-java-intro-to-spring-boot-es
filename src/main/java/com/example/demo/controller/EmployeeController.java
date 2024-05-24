package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.model.Status;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesByStatus(@PathVariable Status status) {
        return employeeRepository.findByStatus(status);
    }

    @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return employeeRepository.findByDepartment(department);
    }
}
