package com.example.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    private Long patientId;
    private String name;
    private LocalDate dateOfBirth;
    @ManyToOne
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
