package org.ironhack.lab402.Controller;

import org.ironhack.lab402.Model.Employee;
import org.ironhack.lab402.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public List<Employee> getAllEmployeess(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getEmployeesByStatus(@PathVariable String status){
        return employeeRepository.findByStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department){
        return employeeRepository.findByDepartment(department);
    }
}
