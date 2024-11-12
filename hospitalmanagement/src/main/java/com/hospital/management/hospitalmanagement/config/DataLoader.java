package com.hospital.management.hospitalmanagement.config;

import com.hospital.management.hospitalmanagement.entity.Employee;
import com.hospital.management.hospitalmanagement.entity.Patient;
import com.hospital.management.hospitalmanagement.repository.EmployeeRepository;
import com.hospital.management.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee emp1 = new Employee(356712, "cardiology", "Alonso Flores", Employee.Status.ON_CALL);
        Employee emp2 = new Employee(564134, "immunology", "Sam Ortega", Employee.Status.ON);
        Employee emp3 = new Employee(761527, "cardiology", "German Ruiz", Employee.Status.OFF);
        Employee emp4 = new Employee(166552, "pulmonary", "Maria Lin", Employee.Status.ON);
        Employee emp5 = new Employee(156545, "orthopaedic", "Paolo Rodriguez", Employee.Status.ON_CALL);
        Employee emp6 = new Employee(172456, "psychiatric", "John Paul Armes", Employee.Status.OFF);

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);
        employeeRepository.save(emp4);
        employeeRepository.save(emp5);
        employeeRepository.save(emp6);

        patientRepository.save(new Patient(1, "Jaime Jordan", LocalDate.of(1984, 3, 2), emp2));
        patientRepository.save(new Patient(2, "Marian Garcia", LocalDate.of(1972, 1, 12), emp2));
        patientRepository.save(new Patient(3, "Julia Dusterdieck", LocalDate.of(1954, 6, 11), emp1));
        patientRepository.save(new Patient(4, "Steve McDuck", LocalDate.of(1931, 11, 10), emp3));
        patientRepository.save(new Patient(5, "Marian Garcia", LocalDate.of(1999, 2, 15), emp6));
    }
}

