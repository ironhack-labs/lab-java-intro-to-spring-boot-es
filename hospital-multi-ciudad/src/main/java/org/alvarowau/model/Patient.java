package org.alvarowau.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Patient {
    @Id
    @Column(name = "patient_id")
    private Long id;

    private String name;

    @Column(name = "date_of_birth")
    private LocalDate birthDate;


    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_id")
    private Employee employee;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", employeeId=" + employee +
                '}';
    }
}
