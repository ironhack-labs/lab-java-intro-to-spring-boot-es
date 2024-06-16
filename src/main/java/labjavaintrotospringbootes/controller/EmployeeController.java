package labjavaintrotospringbootes.controller;

import labjavaintrotospringbootes.model.Employee;
import labjavaintrotospringbootes.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 1. Obtener todos los médicos
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // 2. Obtener médico por ID
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    // 3. Obtener médicos por estado (status)
    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getByStatus(@PathVariable String status){
        return employeeService.getByStatus(status);
    }

    // 4. Obtener médicos por departamento
    @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getByDepartment(@PathVariable String department){
        return employeeService.getByDepartment(department);
    }
}
