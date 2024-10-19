package org.alvarowau.dto.patient;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PatientRequest(Long id, String name, LocalDate birthDate,
                             Long employeeId) {
}
