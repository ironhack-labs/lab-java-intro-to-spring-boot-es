package com.miguelprojects.lab_402_intro_to_spring_boot.controller;

import com.miguelprojects.lab_402_intro_to_spring_boot.Enums.Status;
import com.miguelprojects.lab_402_intro_to_spring_boot.model.Employee;
import com.miguelprojects.lab_402_intro_to_spring_boot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;




//    Obtener todos los médicos (doctors): Crear una ruta para obtener todos los médicos.
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

//    Obtener médico por ID: Crear una ruta para obtener un médico por employee_id.
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).get();
    }

//    Obtener médicos por estado (status): Crear una ruta para obtener médicos por status.
    @GetMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByStatus(@RequestParam Status status) {
        return employeeRepository.findByStatus(status);
    }

//    Obtener médicos por departamento: Crear una ruta para obtener médicos por department.
    @GetMapping("/department")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByDepartment(@RequestParam String department) {
        return employeeRepository.findByDepartment(department);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
