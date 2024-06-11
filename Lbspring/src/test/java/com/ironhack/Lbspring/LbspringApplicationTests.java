package com.ironhack.Lbspring;

import com.ironhack.Lbspring.model.Employee;
import com.ironhack.Lbspring.model.Patient;
import com.ironhack.Lbspring.repository.EmployeeRepository;
import com.ironhack.Lbspring.repository.PatientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Date;

@SpringBootApplication
public class LbspringApplication {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(LbspringApplication.class, args);
    }

    @PostConstruct
    public void init() {
        // Crear y guardar empleados
        Employee emp1 = new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL");
        Employee emp2 = new Employee(564134L, "immunology", "Sam Ortega", "ON");
        Employee emp3 = new Employee(761527L, "cardiology", "German Ruiz", "OFF");
        Employee emp4 = new Employee(166552L, "pulmonary", "Maria Lin", "ON");
        Employee emp5 = new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL");
        Employee emp6 = new Employee(172456L, "psychiatric", "John Paul Armes", "OFF");

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);
        employeeRepository.save(emp4);
        employeeRepository.save(emp5);
        employeeRepository.save(emp6);

        // Crear y guardar pacientes
        Patient pat1 = new Patient(1L, "Jaime Jordan", new Date(84, 2, 2), emp2);
        Patient pat2 = new Patient(2L, "Marian Garcia", new Date(72, 0, 12), emp2);
        Patient pat3 = new Patient(3L, "Julia Dusterdieck", new Date(54, 5, 11), emp1);
        Patient pat4 = new Patient(4L, "Steve McDuck", new Date(31, 10, 10), emp3);
        Patient pat5 = new Patient(5L, "Marian Garcia", new Date(99, 1, 15), emp6);

        patientRepository.save(pat1);
        patientRepository.save(pat2);
        patientRepository.save(pat3);
        patientRepository.save(pat4);
        patientRepository.save(pat5);
    }
}
