package org.amazon.lab4_02.Repositorio;

import org.amazon.lab4_02.Model.Employee;
import org.amazon.lab4_02.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByStatus(Status status);
    List<Employee> findAllByDepartment(String department);
}
