package org.alvarowau.service.interfaces;

import org.alvarowau.dto.employee.EmployeeRequest;
import org.alvarowau.dto.employee.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {
    EmployeeResponse update(Long id, EmployeeRequest employeeRequest) throws Exception;

    List<EmployeeResponse> getDoctorsByStatus(String status) throws Exception;

    boolean delete(Long employeeId) throws Exception;

    EmployeeResponse save(EmployeeRequest employeeRequest) throws Exception;

    EmployeeResponse findById(Long id) throws Exception;

    List<EmployeeResponse> findAll() throws Exception;

    List<EmployeeResponse> getDoctorsByDepartment(String department) throws Exception;
}

