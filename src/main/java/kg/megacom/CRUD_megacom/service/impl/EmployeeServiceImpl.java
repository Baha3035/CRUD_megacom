package kg.megacom.CRUD_megacom.service.impl;

import kg.megacom.CRUD_megacom.dao.EmployeeRepo;
import kg.megacom.CRUD_megacom.mappers.EmployeeMapper;
import kg.megacom.CRUD_megacom.mappers.SalaryMapper;
import kg.megacom.CRUD_megacom.models.dto.EmployeeDto;
import kg.megacom.CRUD_megacom.models.dto.SalaryDto;
import kg.megacom.CRUD_megacom.models.dto.outputs.EmployeeResponseDto;
import kg.megacom.CRUD_megacom.models.entity.Employee;
import kg.megacom.CRUD_megacom.service.EmployeeService;
import kg.megacom.CRUD_megacom.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private SalaryService salaryService;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return EmployeeMapper.INSTANCE.toDtos(employeeRepo.findAll()).stream().filter(x -> x.isActive()==true).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto saveEmployee(EmployeeResponseDto employeeDto) {
        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setName(employeeDto.getName());
        employeeDto1.setSurname(employeeDto.getSurname());
        employeeDto1.setActive(true);
        EmployeeDto employeeDtoSaved = EmployeeMapper.INSTANCE.toDto(employeeRepo.save(EmployeeMapper.INSTANCE.toEntity(employeeDto1)));
        SalaryDto salaryDto = new SalaryDto();
        salaryDto.setSalary(employeeDto.getSalary());
        salaryDto.setEmployeeDto(employeeDto1);
        SalaryDto salaryDtoSaved = salaryService.saveSalaryWithDate(salaryDto);
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setSalary(salaryDtoSaved.getSalary());
        employeeResponseDto.setName(employeeDtoSaved.getName());
        employeeResponseDto.setSurname(employeeDtoSaved.getSurname());
        employeeResponseDto.setId(employeeDtoSaved.getId());

        return employeeResponseDto;
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found!!!"));
        employee.setActive(false);
        employeeRepo.save(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public EmployeeResponseDto update(Long id, EmployeeResponseDto employeeDto) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found!!!"));

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        SalaryDto salaryOfUpdatingEmp = salaryService.findSalaryByEmployeeIdAndCurrentSalaryBetweenSysdate(id);
        if(employeeDto.getSalary() != salaryOfUpdatingEmp.getSalary()){
            SalaryDto salaryDto = new SalaryDto();
            salaryDto.setSalary(employeeDto.getSalary());
            salaryDto.setEmployeeDto(EmployeeMapper.INSTANCE.toDto(employee));
            SalaryDto savedSalary = salaryService.saveSalaryWithDate(salaryDto);
            salaryOfUpdatingEmp.setEndDate(new Date());
            employeeResponseDto.setSalary(savedSalary.getSalary());
        }
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());

        EmployeeDto savedEmployee = EmployeeMapper.INSTANCE.toDto(employeeRepo.save(employee));
        employeeResponseDto.setName(savedEmployee.getName());
        employeeResponseDto.setId(savedEmployee.getId());
        employeeResponseDto.setSurname(savedEmployee.getSurname());
        employeeResponseDto.setSalary(salaryOfUpdatingEmp.getSalary());

        return employeeResponseDto;
    }
}
