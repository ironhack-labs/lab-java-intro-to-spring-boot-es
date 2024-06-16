package labjavaintrotospringbootes.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "name")
    private String patientName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;

    public Patient() {
    }

    public Patient(Integer patientId, String patientName, LocalDate dateOfBirth, Employee admittedBy) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
