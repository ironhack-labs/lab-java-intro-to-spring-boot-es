package org.alvarowau.model;

import jakarta.persistence.*;
import lombok.*;
import org.alvarowau.model.enums.StatusEmployee;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Long id;

    private String department;
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEmployee status;

    @OneToMany(mappedBy = "employee")
    private List<Patient> patients = new ArrayList<>();


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", patients=" + patients +
                '}';
    }
}
