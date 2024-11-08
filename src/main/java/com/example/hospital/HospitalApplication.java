package com.example.hospital;

import jakarta.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Entity
    @Table(name = "employee")
    public static class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long employeeId;

        private String department;
        private String name;
        private String status;

        public Employee() {}
        public Employee(String department, String name, String status) {
            this.department = department;
            this.name = name;
            this.status = status;
        }

        public Long getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    @Entity
    @Table(name = "patient")
    public static class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long patientId;

        private String name;
        private LocalDate dateOfBirth;

        @ManyToOne
        @JoinColumn(name = "admitted_by")
        private Employee admittedBy;

        public Patient() {}
        public Patient(String name, LocalDate dateOfBirth, Employee admittedBy) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.admittedBy = admittedBy;
        }

        // Getters y Setters
        public Long getPatientId() {
            return patientId;
        }

        public void setPatientId(Long patientId) {
            this.patientId = patientId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public Employee getAdmittedBy() {
            return admittedBy;
        }

        public void setAdmittedBy(Employee admittedBy) {
            this.admittedBy = admittedBy;
        }
    }

    @Repository
    public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        List<Employee> findByStatus(String status);
        List<Employee> findByDepartment(String department);
    }

    @Repository
    public interface PatientRepository extends JpaRepository<Patient, Long> {
        List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
        List<Patient> findByAdmittedByDepartment(String department);
        List<Patient> findByAdmittedByStatus(String status);
    }

    @RestController
    @RequestMapping("/api")
    public static class HospitalController {

        private final EmployeeRepository employeeRepository;
        private final PatientRepository patientRepository;

        public HospitalController(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
            this.employeeRepository = employeeRepository;
            this.patientRepository = patientRepository;
        }

        @GetMapping("/employees")
        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        @GetMapping("/employees/{employeeId}")
        public Employee getEmployeeById(@PathVariable Long employeeId) {
            return employeeRepository.findById(employeeId).orElse(null);
        }

        @GetMapping("/employees/status/{status}")
        public List<Employee> getEmployeesByStatus(@PathVariable String status) {
            return employeeRepository.findByStatus(status);
        }

        @GetMapping("/employees/department/{department}")
        public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
            return employeeRepository.findByDepartment(department);
        }

        @GetMapping("/patients")
        public List<Patient> getAllPatients() {
            return patientRepository.findAll();
        }

        @GetMapping("/patients/{patientId}")
        public Patient getPatientById(@PathVariable Long patientId) {
            return patientRepository.findById(patientId).orElse(null);
        }

        @GetMapping("/patients/birthdate")
        public List<Patient> getPatientsByBirthdateRange(
                @RequestParam("start") String startDate,
                @RequestParam("end") String endDate) {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            return patientRepository.findByDateOfBirthBetween(start, end);
        }

        @GetMapping("/patients/department/{department}")
        public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
            return patientRepository.findByAdmittedByDepartment(department);
        }

        @GetMapping("/patients/status/off")
        public List<Patient> getPatientsByDoctorStatusOff() {
            return patientRepository.findByAdmittedByStatus("OFF");
        }
    }

    @Bean
    public CommandLineRunner dataLoader(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        return args -> {

            Employee employee1 = new Employee("cardiology", "Alonso Flores", "ON_CALL");
            Employee employee2 = new Employee("immunology", "Sam Ortega", "ON");
            Employee employee3 = new Employee("cardiology", "German Ruiz", "OFF");
            Employee employee4 = new Employee("pulmonary", "Maria Lin", "ON");
            Employee employee5 = new Employee("orthopaedic", "Paolo Rodriguez", "ON_CALL");
            Employee employee6 = new Employee("psychiatric", "John Paul Armes", "OFF");

            employeeRepository.save(employee1);
            employeeRepository.save(employee2);
            employeeRepository.save(employee3);
            employeeRepository.save(employee4);
            employeeRepository.save(employee5);
            employeeRepository.save(employee6);

            Patient patient1 = new Patient("Jaime Jordan", LocalDate.of(1984, 3, 2), employee2);
            Patient patient2 = new Patient("Marian Garcia", LocalDate.of(1972, 1, 12), employee2);
            Patient patient3 = new Patient("Julia Dusterdieck", LocalDate.of(1954, 6, 11), employee1);
            Patient patient4 = new Patient("Steve McDuck", LocalDate.of(1931, 11, 10), employee3);
            Patient patient5 = new Patient("Marian Garcia", LocalDate.of(1999, 2, 15), employee6);

            patientRepository.save(patient1);
            patientRepository.save(patient2);
            patientRepository.save(patient3);
            patientRepository.save(patient4);
            patientRepository.save(patient5);
        };
    }
}