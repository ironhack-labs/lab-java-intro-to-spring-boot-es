package org.alvarowau.dto.mapper;

import org.alvarowau.model.Employee;
import org.alvarowau.model.Patient;
import org.alvarowau.dto.patient.PatientRequest;
import org.alvarowau.dto.patient.PatientRequestWithDoctor;
import org.alvarowau.dto.patient.PatientResponse;

public class PatientMapper {

    // Map Patient entity to PatientResponse DTO
    public static PatientResponse toPatientResponse(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .birthDate(patient.getBirthDate())
                .employeeId(patient.getEmployee().getId())
                .build();
    }

    // Map PatientRequestWithDoctor DTO to Patient entity
    public static Patient toPatient(PatientRequestWithDoctor patientRequestWithDoctor) {
        return Patient.builder()
                .id(patientRequestWithDoctor.id())
                .name(patientRequestWithDoctor.name())
                .birthDate(patientRequestWithDoctor.birthDate())
                .employee(patientRequestWithDoctor.employee())
                .build();
    }

    // Map PatientRequest DTO and Employee to PatientRequestWithDoctor DTO
    public static PatientRequestWithDoctor toPatientRequestWithDoctor(PatientRequest patientRequest, Employee employee) {
        return PatientRequestWithDoctor.builder()
                .id(patientRequest.id())
                .name(patientRequest.name())
                .birthDate(patientRequest.birthDate())
                .employee(employee)
                .build();
    }
}
