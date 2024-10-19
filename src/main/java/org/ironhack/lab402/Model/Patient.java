package org.ironhack.lab402.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id

    private Integer patientId;
    private String name;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employeeId")
    private Employee admittedBy;

    public Patient() {}

    public Patient(Integer patientId, String name, LocalDate dateOfBirth, Employee admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public Patient(Integer patientId, String name, LocalDate dateOfBirth) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Patient(Employee admittedBy) {
        this.admittedBy = admittedBy;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
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
