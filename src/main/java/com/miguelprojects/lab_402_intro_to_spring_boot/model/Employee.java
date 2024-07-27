package com.miguelprojects.lab_402_intro_to_spring_boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miguelprojects.lab_402_intro_to_spring_boot.Enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
@DynamicUpdate

public class Employee {
    @Id
    @Column(name="employee_id")
    private Long employeeId;

    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patientList;

    public Employee() {    }

    public Employee(Long employeeId, String department, String name, Status status, List<Patient> patientList) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
        this.patientList = patientList;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(department, employee.department) && Objects.equals(name, employee.name) && status == employee.status && Objects.equals(patientList, employee.patientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, department, name, status, patientList);
    }
}
