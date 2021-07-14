package kg.megacom.CRUD_megacom.dao;

import kg.megacom.CRUD_megacom.models.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
