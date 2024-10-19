package org.ironhack.lab402.Controller;

import org.ironhack.lab402.Model.Patient;
import org.ironhack.lab402.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return patientRepository.findById(id).orElse(null);
    }

    @GetMapping("/dateOfBirth")
    public List<Patient> getPatientByDateOfBirthRange(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                      @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department){
        return patientRepository.findByDoctorsDepartment(department);
    }

    @GetMapping("/doctorStatusOff")
    public List<Patient> getPatientsWithDoctorsOff() {
        return patientRepository.findByDoctorsOffStatus();
    }

}
