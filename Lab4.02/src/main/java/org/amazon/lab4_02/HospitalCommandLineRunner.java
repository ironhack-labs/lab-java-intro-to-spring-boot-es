package org.amazon.lab4_02;

import org.amazon.lab4_02.Model.Employee;
import org.amazon.lab4_02.Model.Patient;
import org.amazon.lab4_02.Model.Status;
import org.amazon.lab4_02.Repositorio.EmployeeRepository;
import org.amazon.lab4_02.Repositorio.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class HospitalCommandLineRunner implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
    Employee employee1 = new Employee(356712,"cardiology","Alonso Flores", Status.ON_CALL);
    Employee employee2 = new Employee (564134,"immunology","Sam Ortega",Status.ON);
    Employee employee3 = new Employee (761527,"cardiology","German Ruiz",Status.OFF);
    Employee employee4 = new Employee (166552,"pulmonary","Maria Lin",Status.ON);
    Employee employee5 = new Employee (156545,"orthopaedic","Paolo Rodriguez",Status.ON_CALL);
    Employee employee6 = new Employee (172456,"psychiatric","John Paul Armes",Status.OFF);
    employeeRepository.save(employee1);
    employeeRepository.save(employee2);
    employeeRepository.save(employee3);
    employeeRepository.save(employee4);
    employeeRepository.save(employee5);
    employeeRepository.save(employee6);

    Patient patient1 = new Patient(1L,"Jaime Jordan", LocalDate.of(1984,3,2),employee2);
    Patient patient2 = new Patient(2L,"Marian Garcia",LocalDate.of(1972,1,12),employee2);
    Patient patient3 = new Patient(3L,"Julia Dusterdieck",LocalDate.of(1954,6,11),employee1);
    Patient patient4 = new Patient(4L,"Steve McDuck",LocalDate.of(1931,11,10),employee3);
    Patient patient5 = new Patient(5L,"Marian Garcia",LocalDate.of(1999,2,15),employee6);
    patientRepository.save(patient1);
    patientRepository.save(patient2);
    patientRepository.save(patient3);
    patientRepository.save(patient4);
    patientRepository.save(patient5);
    }
}
