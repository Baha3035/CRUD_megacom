package kg.megacom.CRUD_megacom.controllers;

import kg.megacom.CRUD_megacom.mappers.EmployeeMapper;
import kg.megacom.CRUD_megacom.models.dto.EmployeeDto;
import kg.megacom.CRUD_megacom.models.dto.outputs.EmployeeResponseDto;
import kg.megacom.CRUD_megacom.models.entity.Employee;
import kg.megacom.CRUD_megacom.service.EmployeeService;
import kg.megacom.CRUD_megacom.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeResponseDto> saveEmployee(@RequestBody EmployeeResponseDto employeeDto){
        return new ResponseEntity<EmployeeResponseDto>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@RequestParam Long id, @RequestBody EmployeeResponseDto employeeDto){
        return new ResponseEntity<EmployeeResponseDto>(employeeService.update(id, employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeDto>> findAll(){
        return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployees(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Boolean>> delete(@RequestParam Long id){
        return new ResponseEntity<Map<String, Boolean>>(employeeService.delete(id), HttpStatus.ACCEPTED);
    }
}