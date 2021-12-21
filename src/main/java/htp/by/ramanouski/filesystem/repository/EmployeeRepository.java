package htp.by.ramanouski.filesystem.repository;

import htp.by.ramanouski.filesystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    EmployeeEntity findByUserId(String userId);
}
