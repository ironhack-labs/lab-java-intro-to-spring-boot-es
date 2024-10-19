package org.alvarowau.service.interfaces;

import org.alvarowau.dto.patient.PatientRequest;
import org.alvarowau.dto.patient.PatientResponse;

import java.util.List;

public interface IPatientService {
    boolean delete(Long patientId) throws Exception;

    PatientResponse update(Long id, PatientRequest patientRequest) throws Exception;

    PatientResponse save(PatientRequest patientRequest) throws Exception;

    PatientResponse findById(Long id) throws Exception;

    List<PatientResponse> findAll() throws Exception;

    List<PatientResponse> getPatientsByBirthDateRange(String startDate, String endDate) throws Exception;

    List<PatientResponse> getPatientsByDoctorDepartment(String department) throws Exception;

    List<PatientResponse> getPatientsWithDoctorUnavailable() throws Exception;
}
