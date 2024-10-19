package org.ironhack.lab402;

import org.ironhack.lab402.Model.Employee;
import org.ironhack.lab402.Model.Patient;
import org.ironhack.lab402.Repository.EmployeeRepository;
import org.ironhack.lab402.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public DataLoader(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        this.employeeRepository = employeeRepository;
        this.patientRepository = patientRepository;
    }

    public void run(String... args) throws Exception{

        employeeRepository.save(new Employee(356712, "Cardiology", "Alonso Flores", "ON_CALL"));
        employeeRepository.save(new Employee(564134, "immunology", "Sam Ortega", "ON"));
        employeeRepository.save(new Employee(761527, "cardiology", "German Ruiz", "OFF"));
        employeeRepository.save(new Employee(166552, "pulmonary", "Maria Lin", "ON"));
        employeeRepository.save(new Employee(156545, "orthopaedic", "Paolo Rodriguez", "ON_CALL"));
        employeeRepository.save(new Employee(172456, "psychiatric", "John Paul Armes", "OFF"));

        Employee empleado1 = employeeRepository.findById(356712).orElseThrow();
        Employee empleado2 = employeeRepository.findById(564134).orElseThrow();
        Employee empleado3 = employeeRepository.findById(761527).orElseThrow();
        Employee empleado4 = employeeRepository.findById(166552).orElseThrow();
        Employee empleado5 = employeeRepository.findById(156545).orElseThrow();
        Employee empleado6 = employeeRepository.findById(172456).orElseThrow();

        patientRepository.save(new Patient(1,"Jaime Jordan", LocalDate.of(1984, 3, 2), empleado2));
        patientRepository.save(new Patient(2,"Marian Garcia", LocalDate.of(1972, 1, 12), empleado2));
        patientRepository.save(new Patient(3,"Julia Dusterdieck", LocalDate.of(1954, 6, 11), empleado1));
        patientRepository.save(new Patient(4,"Steve McDuck", LocalDate.of(1931, 11, 10), empleado3));
        patientRepository.save(new Patient(5,"Marian Garcia", LocalDate.of(1999, 2, 15), empleado6));

    }


}
