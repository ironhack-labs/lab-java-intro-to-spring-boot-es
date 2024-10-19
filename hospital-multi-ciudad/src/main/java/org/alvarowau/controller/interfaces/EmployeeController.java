package org.alvarowau.controller.interfaces;

import org.alvarowau.dto.employee.EmployeeRequest;
import org.springframework.http.ResponseEntity;

public interface EmployeeController {
    ResponseEntity<?> getEmployeeById(Long id);

    ResponseEntity<?> getAllEmployees();

    ResponseEntity<?> createNewEmployee(EmployeeRequest employeeRequest);

    ResponseEntity<?> updateExistingEmployee(Long id, EmployeeRequest employeeRequest);

    ResponseEntity<?> deleteEmployeeById(Long id);

    ResponseEntity<?> findDoctorsByStatus(String status);

    ResponseEntity<?> findDoctorsByDepartment(String department);
}
