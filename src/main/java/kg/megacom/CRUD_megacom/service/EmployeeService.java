package kg.megacom.CRUD_megacom.service;

import kg.megacom.CRUD_megacom.models.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
}
