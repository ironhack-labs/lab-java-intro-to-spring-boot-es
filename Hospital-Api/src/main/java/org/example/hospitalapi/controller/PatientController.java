package org.example.hospitalapi.controller;

import org.example.hospitalapi.enums.EmployeeStatus;
import org.example.hospitalapi.model.Employee;
import org.example.hospitalapi.model.Patient;
import org.example.hospitalapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/patients")
public class PatientController {

  @Autowired
  private PatientRepository patientRepository;

  @GetMapping("/getAllPatients")
  public ResponseEntity<List<Patient>> getAllPatients() {
    List<Patient> patients = patientRepository.findAll();
    if (!patients.isEmpty()) {
      return ResponseEntity.ok(patients);
    }else{
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/findById/{id}")
  public ResponseEntity<Patient> findById(@PathVariable Long id) {
    Optional<Patient> patient = patientRepository.findById(id);
    if (patient.isPresent()) {
      return ResponseEntity.ok(patient.get());
    }else{
      return ResponseEntity.notFound().build();
    }
  }
  @GetMapping("/findByBirthDateRange") //GET /api/patients/findByBirthDateRange?from=1980-01-01&to=1990-12-31
  public ResponseEntity<List<Patient>> findById(
          @RequestParam LocalDate from,
          @RequestParam LocalDate to) {
    List<Patient> patients = patientRepository.findPatientsByDateOfBirthBetween(from, to);
    if (!patients.isEmpty()) {
      return ResponseEntity.ok(patients);
    }else{
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/findPatientsByMedicalDepartment/{medicalDepartment}")
  public ResponseEntity<List<Patient>> findById(
          @PathVariable
          String medicalDepartment) {
    List<Patient> patients = patientRepository.findPatientsByAdmittedBy_Department(medicalDepartment);
    if (!patients.isEmpty()) {
      return ResponseEntity.ok(patients);
    }else{
      return ResponseEntity.notFound().build();
    }
  }
  @GetMapping("/findPatientsByMedicalStatus/{status}") //status OFF = 2
  public ResponseEntity<List<Patient>> findById(
          @PathVariable
          int status) {
    List<Patient> patients;
    if (status == 0){
      patients = patientRepository.findPatientsByAdmittedByEmployeeStatus(EmployeeStatus.ON_CALL);
      return somethingToResponse(patients);
    }else if (status == 1){
      patients = patientRepository.findPatientsByAdmittedByEmployeeStatus(EmployeeStatus.ON);
      return somethingToResponse(patients);
    }else if (status == 2){
      patients = patientRepository.findPatientsByAdmittedByEmployeeStatus(EmployeeStatus.OFF);
      return somethingToResponse(patients);
    }else {
      return ResponseEntity.notFound().build();
    }
  }

  public ResponseEntity<List<Patient>> somethingToResponse(List<Patient> patients){
    if(!patients.isEmpty()){
      return ResponseEntity.ok(patients);
    }else {
      return ResponseEntity.notFound().build();
    }
  }


}
