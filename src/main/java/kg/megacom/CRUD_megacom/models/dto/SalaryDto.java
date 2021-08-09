package kg.megacom.CRUD_megacom.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SalaryDto {
    private Long id;
    private double salary;
    private EmployeeDto employeeDto;
    private Date startDate;
    private Date endDate;
}
