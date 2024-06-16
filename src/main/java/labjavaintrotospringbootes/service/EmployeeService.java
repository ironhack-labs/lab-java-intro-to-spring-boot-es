package labjavaintrotospringbootes.service;

import labjavaintrotospringbootes.model.Employee;
import labjavaintrotospringbootes.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. Obtener todos los médicos
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // 2. Obtener médico por ID
    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found."));
    }

    // 3. Obtener médicos por estado (status)
    public List<Employee> getByStatus (String status){
        return employeeRepository.findByStatus(status);
    }

    // 4. Obtener médicos por departamento
    public List<Employee> getByDepartment (String department){
        return employeeRepository.findByDepartment(department);
    }

}

