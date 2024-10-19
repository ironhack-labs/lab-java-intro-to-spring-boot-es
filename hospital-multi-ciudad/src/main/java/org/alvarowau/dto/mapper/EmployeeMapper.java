package org.alvarowau.dto.mapper;

import org.alvarowau.model.Employee;
import org.alvarowau.dto.employee.EmployeeRequest;
import org.alvarowau.dto.employee.EmployeeResponse;

public class EmployeeMapper {

    // Convert Employee entity to EmployeeResponse DTO
    public static EmployeeResponse toEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .department(employee.getDepartment())
                .name(employee.getName())
                .status(employee.getStatus())
                .build();
    }

    // Convert EmployeeRequest DTO to Employee entity
    public static Employee toEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .id(employeeRequest.id())
                .department(employeeRequest.department())
                .name(employeeRequest.name())
                .status(employeeRequest.status())
                .build();
    }
}
