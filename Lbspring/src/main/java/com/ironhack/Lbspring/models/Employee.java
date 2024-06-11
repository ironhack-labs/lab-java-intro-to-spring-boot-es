package com.ironhack.Lbspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Employee {

    @Id
    private Long employee_id;
    private String department;
    private String name;
    private String status;

    // Getters y setters

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
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
