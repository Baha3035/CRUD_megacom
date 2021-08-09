package kg.megacom.CRUD_megacom.dao;

import kg.megacom.CRUD_megacom.models.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long> {
    @Query(value = "SELECT * FROM salaries s WHERE s.id_employees = ?1 and CURRENT_TIMESTAMP BETWEEN s.start_date and s.end_date",nativeQuery = true)
    Salary findSalaryByEmployeeIdAndCurrentSalaryBetweenSysdate(Long id);

    @Query(value = "SELECT * FROM salaries s WHERE CURRENT_TIMESTAMP BETWEEN s.start_date and s.end_date",nativeQuery = true)
    List<Salary> findAllByCurrentSalary();
}
