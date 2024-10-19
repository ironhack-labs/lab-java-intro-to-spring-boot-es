package org.alvarowau.controller.impl;

import lombok.RequiredArgsConstructor;
import org.alvarowau.controller.interfaces.PatientController;
import org.alvarowau.dto.patient.PatientRequest;
import org.alvarowau.service.impl.PatientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientControllerImpl implements PatientController {

    private final PatientServiceImpl patientService;

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getPatientById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(patientService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al recuperar el paciente: " + e.getMessage());
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getAllPatients() {
        try {
            return ResponseEntity.ok(patientService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al recuperar la lista de pacientes: " + e.getMessage());
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest patientRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(patientService.save(patientRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el paciente: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody PatientRequest patientRequest) {
        try {
            return ResponseEntity.ok(patientService.update(id, patientRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el paciente: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> deletePatientById(@PathVariable Long id) {
        try {
            if (patientService.delete(id)) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("El paciente fue eliminado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El paciente con id " + id + " no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el paciente: " + e.getMessage());
        }
    }

    @GetMapping("/birthdate")
    @Override
    public ResponseEntity<?> findPatientsByBirthDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        try {
            return ResponseEntity.ok(patientService.getPatientsByBirthDateRange(startDate, endDate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar pacientes por rango de fechas: " + e.getMessage());
        }
    }

    @GetMapping("/department/{department}")
    @Override
    public ResponseEntity<?> findPatientsByDoctorDepartment(@PathVariable String department) {
        try {
            return ResponseEntity.ok(patientService.getPatientsByDoctorDepartment(department));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar pacientes por departamento: " + e.getMessage());
        }
    }

    @GetMapping("/doctor-status/OFF")
    @Override
    public ResponseEntity<?> findPatientsWithDoctorUnavailable() {
        try {
            return ResponseEntity.ok(patientService.getPatientsWithDoctorUnavailable());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar pacientes con doctor no disponible: " + e.getMessage());
        }
    }
}
