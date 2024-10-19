package org.ironhack.lab402.Repository;

import org.ironhack.lab402.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);

}
