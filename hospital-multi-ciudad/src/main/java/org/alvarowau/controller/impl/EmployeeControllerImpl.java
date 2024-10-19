package org.alvarowau.controller.impl;

import lombok.RequiredArgsConstructor;
import org.alvarowau.controller.interfaces.EmployeeController;
import org.alvarowau.dto.employee.EmployeeRequest;
import org.alvarowau.service.impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al recuperar el empleado: " + e.getMessage());
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getAllEmployees() {
        try {
            return ResponseEntity.ok(employeeService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al recuperar la lista de empleados: " + e.getMessage());
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<?> createNewEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(employeeService.save(employeeRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el empleado: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> updateExistingEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        try {
            return ResponseEntity.ok(employeeService.update(id, employeeRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el empleado: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        try {
            if (employeeService.delete(id)) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Empleado eliminado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El empleado con el id " + id + " no se pudo eliminar");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el empleado: " + e.getMessage());
        }
    }

    @GetMapping("/status/{status}")
    @Override
    public ResponseEntity<?> findDoctorsByStatus(@PathVariable String status) {
        try {
            return ResponseEntity.ok(employeeService.getDoctorsByStatus(status));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al recuperar doctores por estado: " + e.getMessage());
        }
    }

    @GetMapping("/department/{department}")
    @Override
    public ResponseEntity<?> findDoctorsByDepartment(@PathVariable String department) {
        try {
            return ResponseEntity.ok(employeeService.getDoctorsByDepartment(department));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al recuperar doctores por departamento: " + e.getMessage());
        }
    }
}

