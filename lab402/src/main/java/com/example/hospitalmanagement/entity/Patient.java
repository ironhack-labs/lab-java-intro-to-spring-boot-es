package com.example.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private Long patientId;

    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by_employee_id")
    private Employee admittedBy;

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

