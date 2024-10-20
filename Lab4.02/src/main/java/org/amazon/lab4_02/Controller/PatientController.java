package org.amazon.lab4_02.Controller;

import org.amazon.lab4_02.Model.Patient;
import org.amazon.lab4_02.Model.Status;
import org.amazon.lab4_02.Repositorio.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/allpatient")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{patient_id}")
    public Patient getPatientById(@PathVariable("patient_id") Long id) {
        return patientRepository.findById(id).get();
    }

    @GetMapping("/patient_for_dates")
    public List<Patient> getPatientByDate(LocalDate From, LocalDate To) {
        return patientRepository.findAllByDateOfBirthBetween(From,To);
    }

    @GetMapping("/for_department/{department}")
    public List<Patient> getPatientByDepartment(@PathVariable("department") String department) {
        return patientRepository.findAllByAdmittedBy_department(department);
    }
    @GetMapping("/for_status/{status}")
    public List<Patient> getPatientByStatus(@PathVariable("status") Status status) {
        return patientRepository.findByAdmittedBy_status_(status);
    }

}
