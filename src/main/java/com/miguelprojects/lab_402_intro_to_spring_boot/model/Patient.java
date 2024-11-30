package com.miguelprojects.lab_402_intro_to_spring_boot.model;


import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "patients")
@DynamicUpdate
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;


    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_id")
    private Employee doctor;


    public Patient() {    }

    public Patient(String name, LocalDate dateOfBirth, Employee doctor) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.doctor = doctor;
    }

    public Long getPatientId() {
        return patientId;
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

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId) && Objects.equals(name, patient.name) && Objects.equals(dateOfBirth, patient.dateOfBirth) && Objects.equals(doctor, patient.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, name, dateOfBirth, doctor);
    }
}
