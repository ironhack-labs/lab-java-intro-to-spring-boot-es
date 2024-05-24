package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Employee {
    @Id
    @Column (name = "employee_id")
    private int id;

    private String department;

    private String name;

    @Enumerated (EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "admittedBy")
    private List<Patient> patients;

    public Employee() {
    }

    public Employee(int employee_id, String department, String name, Status status) {
        this.id = employee_id;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getEmployee_id() {
        return id;
    }

    public void setEmployee_id(int employee_id) {
        this.id = employee_id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(department, employee.department) && Objects.equals(name, employee.name) && status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, name, status);
    }
}
