package kg.megacom.CRUD_megacom.service.impl;

import kg.megacom.CRUD_megacom.dao.SalaryRepo;
import kg.megacom.CRUD_megacom.models.entity.Salary;
import kg.megacom.CRUD_megacom.service.EmployeeService;
import kg.megacom.CRUD_megacom.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepo salaryRepo;

    @Autowired
    private EmployeeService employeeService;


    @Override
    public Salary saveSalary(Salary salary) {
        return salaryRepo.save(salary);
    }
}
