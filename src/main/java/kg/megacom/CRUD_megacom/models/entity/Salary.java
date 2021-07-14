package kg.megacom.CRUD_megacom.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "salaries")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @JsonIgnore
    private Date startDate;

    @JsonIgnore
    private Date endDate;
}
