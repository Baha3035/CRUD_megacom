package kg.megacom.CRUD_megacom.service.impl;

import kg.megacom.CRUD_megacom.dao.SalaryRepo;
import kg.megacom.CRUD_megacom.mappers.SalaryMapper;
import kg.megacom.CRUD_megacom.models.dto.SalaryDto;
import kg.megacom.CRUD_megacom.models.entity.Salary;
import kg.megacom.CRUD_megacom.service.EmployeeService;
import kg.megacom.CRUD_megacom.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepo salaryRepo;

    @Autowired
    private EmployeeService employeeService;


    @Override
    public SalaryDto saveSalaryWithDate(SalaryDto salaryDto) {
        salaryDto.setStartDate(new Date());
        salaryDto.setEndDate(new GregorianCalendar(2999, Calendar.DECEMBER, 31).getTime());
        return SalaryMapper.INSTANCE.toDto(salaryRepo.save(SalaryMapper.INSTANCE.toEntity(salaryDto)));
    }

    @Override
    public SalaryDto saveSalary(SalaryDto salaryDto) {
        return SalaryMapper.INSTANCE.toDto(salaryRepo.save(SalaryMapper.INSTANCE.toEntity(salaryDto)));
    }

    @Override
    public SalaryDto findSalaryByEmployeeIdAndCurrentSalaryBetweenSysdate(Long id) {
        return SalaryMapper.INSTANCE.toDto(salaryRepo.findSalaryByEmployeeIdAndCurrentSalaryBetweenSysdate(id));
    }
}
