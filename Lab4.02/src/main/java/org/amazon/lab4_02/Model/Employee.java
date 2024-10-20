package org.amazon.lab4_02.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    private int employeeId;
    private String department;
    private String name;
    private Status status;

//@OneToMany (mappedBy = "admitted_by")
//    private List<Patient> patients = new ArrayList<>();
}
