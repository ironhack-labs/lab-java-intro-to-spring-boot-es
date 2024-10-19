package org.alvarowau.config;

import org.alvarowau.model.Employee;
import org.alvarowau.model.Patient;
import org.alvarowau.model.enums.StatusEmployee;
import org.alvarowau.repository.EmployeeRepository;
import org.alvarowau.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        return args -> {
            // Insertar empleados
            Employee employee1 = new Employee(356712L, "cardiology", "Alonso Flores", StatusEmployee.ON_CALL, null);
            Employee employee2 = new Employee(564134L, "immunology", "Sam Ortega", StatusEmployee.ON, null);
            Employee employee3 = new Employee(761527L, "cardiology", "German Ruiz", StatusEmployee.OFF, null);
            Employee employee4 = new Employee(166552L, "pulmonary", "Maria Lin", StatusEmployee.ON, null);
            Employee employee5 = new Employee(156545L, "orthopaedic", "Paolo Rodriguez", StatusEmployee.ON_CALL, null);
            Employee employee6 = new Employee(172456L, "psychiatric", "John Paul Armes", StatusEmployee.OFF, null);

            employeeRepository.saveAll(Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6));

            // Insertar pacientes
            Patient patient1 = new Patient(1L, "Jaime Jordan", LocalDate
                    .of(1984, 3, 2), employee2);
            Patient patient2 = new Patient(2L, "Marian Garcia", LocalDate.of(1972, 1, 12), employee2);
            Patient patient3 = new Patient(3L, "Julia Dusterdieck", LocalDate.of(1954, 6, 11), employee1);
            Patient patient4 = new Patient(4L, "Steve McDuck", LocalDate.of(1931, 11, 10), employee3);
            Patient patient5 = new Patient(5L, "Marian Garcia", LocalDate.of(1999, 2, 15), employee6);

            patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3, patient4, patient5));
        };
    }

}
