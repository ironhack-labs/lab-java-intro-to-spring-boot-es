package com.ironhack.Lbspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import java.util.Date;

@Entity
public class Patient {

    @Id
    private Long patient_id;
    private String name;
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_id")
    private com.ironhack.Lbspring.model.Employee admittedBy;

    // Getters y setters

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }

    public com.ironhack.Lbspring.model.Employee getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(com.ironhack.Lbspring.model.Employee admittedBy) {
        this.admittedBy = admittedBy;
    }

    public Patient() {
    }

    public Patient(Long patient_id, String name, Date dateOfBirth, com.ironhack.Lbspring.model.Employee admittedBy) {
        this.patient_id = patient_id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }
}
