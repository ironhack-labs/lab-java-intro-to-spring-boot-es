package com.hospital.management.hospitalmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;


@Entity
public class Employee {
    @Id
    private int employeeId;
    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Employee(int i, String cardiology, String alonsoFlores, Status status) {
    }

    public enum Status {
        ON, OFF, ON_CALL
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

