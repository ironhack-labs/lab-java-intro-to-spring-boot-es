package org.alvarowau.dto.patient;

import lombok.Builder;
import org.alvarowau.model.Employee;

import java.time.LocalDate;

@Builder
public record PatientRequestWithDoctor(Long id, String name, LocalDate birthDate,
                                       Employee employee) {
}
