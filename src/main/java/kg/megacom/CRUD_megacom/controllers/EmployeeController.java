package kg.megacom.CRUD_megacom.controllers;

import kg.megacom.CRUD_megacom.mappers.EmployeeMapper;
import kg.megacom.CRUD_megacom.models.dto.EmployeeDto;
import kg.megacom.CRUD_megacom.models.entity.Employee;
import kg.megacom.CRUD_megacom.service.EmployeeService;
import kg.megacom.CRUD_megacom.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
//
//    @Autowired
//    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        Employee employeeRequest = EmployeeMapper.INSTANCE.toEntity(employeeDto);
        Employee employee = employeeService.saveEmployee(employeeRequest);
        EmployeeDto employeeResponse = EmployeeMapper.INSTANCE.toDto(employee);
        return new ResponseEntity<EmployeeDto>(employeeResponse, HttpStatus.CREATED);
    }
}