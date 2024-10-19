package org.alvarowau.service.impl;

import lombok.RequiredArgsConstructor;
import org.alvarowau.model.Employee;
import org.alvarowau.model.Patient;
import org.alvarowau.dto.mapper.PatientMapper;
import org.alvarowau.dto.patient.PatientRequest;
import org.alvarowau.dto.patient.PatientRequestWithDoctor;
import org.alvarowau.dto.patient.PatientResponse;
import org.alvarowau.model.enums.StatusEmployee;
import org.alvarowau.repository.PatientRepository;
import org.alvarowau.service.interfaces.IPatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;
    private final EmployeeServiceImpl employeeServiceImpl;

    @Override
    public List<PatientResponse> findAll() throws Exception {
        try {
            return patientRepository.findAll().stream()
                    .map(PatientMapper::toPatientResponse)
                    .toList();
        } catch (Exception e) {
            handleException("No se pudo acceder a los pacientes", e);
            return null;
        }
    }

    @Override
    public List<PatientResponse> getPatientsByBirthDateRange(String startDate, String endDate) throws Exception {
        try {
            LocalDate start = parseDate(startDate);
            LocalDate end = parseDate(endDate);

            return patientRepository.findByBirthDateBetween(start, end)
                    .stream()
                    .map(PatientMapper::toPatientResponse)
                    .toList();

        } catch (DateTimeParseException e) {
            throw new Exception("Formato de fecha inválido: " + e.getParsedString(), e);
        } catch (Exception e) {
            handleException("No se pudo acceder a los pacientes", e);
            return null;
        }
    }

    @Override
    public List<PatientResponse> getPatientsByDoctorDepartment(String department) throws Exception {
        try {
            return patientRepository.findByEmployeeDepartment(department)
                    .stream()
                    .map(PatientMapper::toPatientResponse)
                    .toList();
        } catch (Exception e) {
            handleException("No se pudo acceder a los pacientes", e);
            return null;
        }
    }

    @Override
    public List<PatientResponse> getPatientsWithDoctorUnavailable() throws Exception {
        try {
            return patientRepository.findByEmployeeStatus(StatusEmployee.OFF)
                    .stream()
                    .map(PatientMapper::toPatientResponse)
                    .toList();
        } catch (Exception e) {
            handleException("No se pudo acceder a los pacientes", e);
            return null;
        }
    }



    @Override
    public PatientResponse findById(Long id) throws Exception {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new Exception("No se pudo acceder al paciente con el id: " + id));
        return PatientMapper.toPatientResponse(patient);
    }

    @Override
    public PatientResponse save(PatientRequest entity) throws Exception {
        try {
            return createOrUpdatePatientResponse(entity);
        } catch (Exception e) {
            throw new Exception("No se pudo guardar el paciente: " + e.getMessage(), e);
        }
    }

    @Override
    public PatientResponse update(Long id, PatientRequest patientRequest) throws Exception {
        if (!patientRepository.existsById(id)) {
            throw new Exception("No existe el paciente con el id: " + id);
        }

        try {
            return createOrUpdatePatientResponse(patientRequest);
        } catch (Exception e) {
            throw new Exception("No se pudo actualizar el paciente: " + e.getMessage(), e);
        }
    }

    private PatientResponse createOrUpdatePatientResponse(PatientRequest patientRequest) throws Exception {
        if (employeeServiceImpl.existDoctorById(patientRequest.employeeId())) {
            Employee employee = employeeServiceImpl.doctorById(patientRequest.employeeId());
            PatientRequestWithDoctor patientRequestWithDoctor = PatientMapper.toPatientRequestWithDoctor(patientRequest, employee);
            return PatientMapper.toPatientResponse(patientRepository.save(PatientMapper.toPatient(patientRequestWithDoctor)));
        } else {
            throw new Exception("El doctor introducido no existe");
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        if (!patientRepository.existsById(id)) {
            throw new Exception("No existe el paciente con el id: " + id);
        }

        try {
            patientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("No se pudo eliminar el paciente con el id: " + id + " " + e.getMessage(), e);
        }
    }

    private LocalDate parseDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date.trim());
    }

    private void handleException(String message, Exception e) throws Exception {
        throw new Exception(message + ". Error: " + e.getMessage(), e);
    }
}
