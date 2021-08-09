package kg.megacom.CRUD_megacom.service;

import kg.megacom.CRUD_megacom.models.dto.EmployeeDto;
import kg.megacom.CRUD_megacom.models.dto.outputs.EmployeeResponseDto;
import kg.megacom.CRUD_megacom.models.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();
    EmployeeResponseDto saveEmployee(EmployeeResponseDto employeeDto);
    Map<String, Boolean> delete(Long id);
    EmployeeResponseDto update(Long id, EmployeeResponseDto employeeDto);
}
