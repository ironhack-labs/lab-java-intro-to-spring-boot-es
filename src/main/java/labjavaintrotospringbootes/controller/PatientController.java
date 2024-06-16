package labjavaintrotospringbootes.controller;

import labjavaintrotospringbootes.model.Patient;
import labjavaintrotospringbootes.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // 5. Obtener todos los pacientes
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    // 6. Obtener paciente por ID
    @GetMapping("/patientId/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable Integer patientId){
        return patientService.getPatientById(patientId);
    }

    // 7. Obtener pacientes por rango de fecha de nacimiento
    @GetMapping("/dateOfBirthBetween")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateOfBirthBetween(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientService.getByDateOfBirthBetween(startDate, endDate);
    }

    // 8. Obtener pacientes por departamento del médico que los admitió
    @GetMapping("/admittedBy/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByAdmittedBy_Department(@PathVariable String department){
        return patientService.getByAdmittedBy_Department(department);
    }

    // 9. Obtener todos los pacientes con un médico cuyo estado es OFF
    @GetMapping("/doctor/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByAdmittedBy_Status(@PathVariable String status){
        return patientService.getByAdmittedBy_Status(status);
    }

}
