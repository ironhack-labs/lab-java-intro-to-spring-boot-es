package org.alvarowau.dto.employee;

import lombok.Builder;
import org.alvarowau.model.enums.StatusEmployee;

@Builder
public record EmployeeResponse(Long id,
                               String name,
                               StatusEmployee status, String department) {
}
