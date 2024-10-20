package org.amazon.lab4_02.Controller;

import jakarta.persistence.Column;
import org.amazon.lab4_02.Model.Employee;
import org.amazon.lab4_02.Model.Status;
import org.amazon.lab4_02.Repositorio.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }

    @GetMapping ("/{employee_id}")
    public Employee getEmployeeById(@PathVariable("employee_id") int employee_id) {
        return employeeRepository.findById(employee_id).get();

        //_____________________Esto es para colocarle mas logica, si esta o no esta______
//        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
//        if (optionalEmployee.isPresent()) {
//            return ResponseEntity.ok(optionalEmployee.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }____________________________________________________________________________

    }
    @GetMapping("/bystatus/{status}")
    public List<Employee> getEmployeeByStatus (@PathVariable("status") Status status){
        return employeeRepository.findByStatus(status);
    }

    @GetMapping("/bydeparmet/{department}")
    public List<Employee> getEmployeeByDeparment (@PathVariable ("department") String department){
        return employeeRepository.findAllByDepartment(department);
    }

}
