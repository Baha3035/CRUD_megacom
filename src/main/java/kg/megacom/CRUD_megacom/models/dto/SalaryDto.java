package kg.megacom.CRUD_megacom.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.megacom.CRUD_megacom.models.entity.Employee;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class SalaryDto {
    private Long id;

    private Long salary;
    private Employee employeeId;
    private Date startDate;
    private Date endDate;
}
