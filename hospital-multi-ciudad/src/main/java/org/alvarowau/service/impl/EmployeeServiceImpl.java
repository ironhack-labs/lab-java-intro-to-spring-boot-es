package org.alvarowau.service.impl;

import lombok.RequiredArgsConstructor;
import org.alvarowau.model.Employee;
import org.alvarowau.dto.employee.EmployeeRequest;
import org.alvarowau.dto.employee.EmployeeResponse;
import org.alvarowau.dto.mapper.EmployeeMapper;
import org.alvarowau.model.enums.StatusEmployee;
import org.alvarowau.repository.EmployeeRepository;
import org.alvarowau.service.interfaces.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponse> findAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::toEmployeeResponse)
                .toList();
    }

    @Override
    public EmployeeResponse findById(Long id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper::toEmployeeResponse)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado el empleado con el id " + id));
    }

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        Employee employee = EmployeeMapper.toEmployee(employeeRequest);
        return EmployeeMapper.toEmployeeResponse(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("No se pudo recuperar el Empleado con el id: " + id);
        }

        Employee employee = EmployeeMapper.toEmployee(employeeRequest);
        employee.setId(id);
        return EmployeeMapper.toEmployeeResponse(employeeRepository.save(employee));
    }

    @Override
    public boolean delete(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new RuntimeException("No existe el empleado con el id: " + employeeId);
        }
        employeeRepository.deleteById(employeeId);
        return true;
    }

    @Override
    public List<EmployeeResponse> getDoctorsByStatus(String status) {
        return employeeRepository.findByStatus(StatusEmployee.valueOf(status))
                .stream()
                .map(EmployeeMapper::toEmployeeResponse)
                .toList();
    }

    @Override
    public List<EmployeeResponse> getDoctorsByDepartment(String department) {
        return employeeRepository.findByDepartment(department)
                .stream()
                .map(EmployeeMapper::toEmployeeResponse)
                .toList();
    }

    public Employee doctorById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public boolean existDoctorById(Long id) {
        return employeeRepository.existsById(id);
    }
}
