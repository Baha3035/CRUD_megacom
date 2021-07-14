package kg.megacom.CRUD_megacom.mappers;

import kg.megacom.CRUD_megacom.models.dto.EmployeeDto;
import kg.megacom.CRUD_megacom.models.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeDto dto);
    EmployeeDto toDto(Employee entity);

    List<Employee> toEntities(List<EmployeeDto> dtos);
    List<EmployeeDto> toDtos(List<Employee> entities);
}
