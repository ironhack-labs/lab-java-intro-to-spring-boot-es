package com.ironhack.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ironhack.spring.model.Employee;
import com.ironhack.spring.repository.EmployeeRepository;

/**
 * EmployeeService
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }
    
    public List<Employee> getEmployeesByStatus(@PathVariable String status) {
        return employeeRepository.findByStatus(status);

    }
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return employeeRepository.findByDepartment(department);
    }
}
