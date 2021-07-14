package kg.megacom.CRUD_megacom.models.dto;

import kg.megacom.CRUD_megacom.models.entity.Salary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String surname;
    private boolean isActive;
    private List<Salary> salaries = new ArrayList<>();
}
