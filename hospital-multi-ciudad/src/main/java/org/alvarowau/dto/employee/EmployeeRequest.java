package org.alvarowau.dto.employee;

import lombok.Builder;
import org.alvarowau.model.enums.StatusEmployee;

@Builder
public record EmployeeRequest(Long id,String department,
                              String name,
                              StatusEmployee status) {
}
