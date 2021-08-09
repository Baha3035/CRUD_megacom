package kg.megacom.CRUD_megacom.models.dto.outputs;

import lombok.Data;

@Data
public class EmployeeResponseDto {
    private Long id;
    private String name;
    private String surname;
    private double salary;
}
