package labjavaintrotospringbootes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "department")
    private String department;

    @Column(name = "name")
    private String employeeName;

    @Column(name = "status")
    private String status;

    @OneToMany (mappedBy = "admittedBy")
    @JsonIgnore
    private List<Patient> patients;

    public Employee() {
    }

    public Employee(Integer id, String department, String employeeName, String status, List<Patient> patients) {
        this.id = id;
        this.department = department;
        this.employeeName = employeeName;
        this.status = status;
        this.patients = patients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer employeeId) {
        this.id = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String employeeStatus) {
        this.status = employeeStatus;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
