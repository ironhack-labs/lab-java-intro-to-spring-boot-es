package com.example.hospital.service;

import com.example.hospital.model.Employee;
import com.example.hospital.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Optional getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    public List<Employee> getEmployeesByStatus(String status) {
        return employeeRepository.finfByStatus(status);
    }
    public List<Employee> getEmployeesByDepartment(String department) {
         return employeeRepository.findByDepartment(department);
    }
}
