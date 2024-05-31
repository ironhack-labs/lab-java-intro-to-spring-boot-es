package com.example.hospital.controller;

import com.example.hospital.model.Employee;
import com.example.hospital.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return (ResponseEntity<Employee>) employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/status/{status}")
    public List<Employee> getEmployeeByStatus(@PathVariable String status) {
        return employeeService.getEmployeesByStatus(status);}
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department);
    }

}
