package org.alvarowau.repository;

import org.alvarowau.model.Employee;
import org.alvarowau.model.enums.StatusEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Encontrar médicos por estado
    List<Employee> findByStatus(StatusEmployee status);

    // Encontrar médicos por departamento
    List<Employee> findByDepartment(String department);
}
