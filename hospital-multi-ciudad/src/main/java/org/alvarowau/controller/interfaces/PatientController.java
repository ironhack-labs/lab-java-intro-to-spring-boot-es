package org.alvarowau.controller.interfaces;

import org.alvarowau.dto.patient.PatientRequest;
import org.springframework.http.ResponseEntity;

public interface PatientController {
    ResponseEntity<?> getPatientById(Long id);

    ResponseEntity<?> getAllPatients();

    ResponseEntity<?> createPatient(PatientRequest patientRequest);

    ResponseEntity<?> updatePatient(Long id, PatientRequest patientRequest);

    ResponseEntity<?> deletePatientById(Long id);

    ResponseEntity<?> findPatientsByBirthDateRange(String startDate, String endDate);

    ResponseEntity<?> findPatientsByDoctorDepartment(String department);

    ResponseEntity<?> findPatientsWithDoctorUnavailable();
}
