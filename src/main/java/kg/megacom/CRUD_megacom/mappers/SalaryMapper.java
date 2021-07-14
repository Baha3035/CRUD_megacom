package kg.megacom.CRUD_megacom.mappers;

import kg.megacom.CRUD_megacom.models.dto.EmployeeDto;
import kg.megacom.CRUD_megacom.models.dto.SalaryDto;
import kg.megacom.CRUD_megacom.models.entity.Employee;
import kg.megacom.CRUD_megacom.models.entity.Salary;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface SalaryMapper {
    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    Salary toEntity(SalaryDto dto);
    SalaryDto toDto(Salary entity);

    List<Salary> toEntities(List<SalaryDto> dtos);
    List<SalaryDto> toDtos(List<Salary> entities);
}
