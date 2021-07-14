package kg.megacom.CRUD_megacom.service.impl;

import kg.megacom.CRUD_megacom.dao.EmployeeRepo;
import kg.megacom.CRUD_megacom.models.entity.Employee;
import kg.megacom.CRUD_megacom.models.entity.Salary;
import kg.megacom.CRUD_megacom.service.EmployeeService;
import kg.megacom.CRUD_megacom.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private SalaryService salaryService;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Salary salary = new Salary();
        salaryService.saveSalary(salary);
        employee.getSalaries().add(salary);
        return employeeRepo.save(employee);
    }
}
