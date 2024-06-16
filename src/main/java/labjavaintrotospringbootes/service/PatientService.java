package labjavaintrotospringbootes.service;

import labjavaintrotospringbootes.model.Employee;
import labjavaintrotospringbootes.model.Patient;
import labjavaintrotospringbootes.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // 5. Obtener todos los pacientes
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    // 6. Obtener paciente por ID
    public Patient getPatientById(Integer patientId){
        return patientRepository.findById(patientId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found."));
    }

    // 7. Obtener pacientes por rango de fecha de nacimiento
    public List<Patient> getByDateOfBirthBetween(LocalDate startDate, LocalDate endDate){
        List<Patient> patients = patientRepository.findByDateOfBirthBetween(startDate, endDate);
        if (patients.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No patients found for this range of Date of birth.");
        }
        return patients;
    }

    // 8. Obtener pacientes por departamento del médico que los admitió
    public List<Patient> getByAdmittedBy_Department(String department){
        List<Patient> patients = patientRepository.findByAdmittedBy_Department(department);
        if (patients.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No patients found that have been admitted by this department.");
        }
        return patients;
    }

    // 9. Obtener todos los pacientes con un médico cuyo estado es OFF
    public List<Patient> getByAdmittedBy_Status(String status){
        List<Patient> patients= patientRepository.findByAdmittedBy_Status(status);
        if (patients.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No patients found their doctor is in this status.");
        }
        return patients;
    }
}
