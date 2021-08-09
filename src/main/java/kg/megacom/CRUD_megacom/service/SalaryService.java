package kg.megacom.CRUD_megacom.service;

import kg.megacom.CRUD_megacom.models.dto.SalaryDto;
import kg.megacom.CRUD_megacom.models.entity.Salary;

public interface SalaryService {
    SalaryDto saveSalary(SalaryDto salaryDto);
    SalaryDto saveSalaryWithDate(SalaryDto salaryDto);
    SalaryDto findSalaryByEmployeeIdAndCurrentSalaryBetweenSysdate(Long id);
}
