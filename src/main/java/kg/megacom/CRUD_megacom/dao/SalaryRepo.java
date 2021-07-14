package kg.megacom.CRUD_megacom.dao;

import kg.megacom.CRUD_megacom.models.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long> {
}
