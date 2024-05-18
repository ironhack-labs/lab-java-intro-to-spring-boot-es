package com.ironhack.hospitalmgmt.controller;

import com.ironhack.hospitalmgmt.model.Employee;
import com.ironhack.hospitalmgmt.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
         private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @GetMapping
        public List<Employee> getAllEmployees() {
            return employeeService.findAll();
        }

        @GetMapping("/{id}")
        public Employee getEmployeeById(@PathVariable Long id) {
            return employeeService.findById(id);
        }

        @GetMapping("/status/{status}")
        public List<Employee> getEmployeesByStatus(@PathVariable String status) {
            return employeeService.findByStatus(status);
        }

        @GetMapping("/department/{department}")
        public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
            return employeeService.findByDepartment(department);
        }
    }
