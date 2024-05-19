package manamaham.amirhossein.kafkatask.repository;

import manamaham.amirhossein.kafkatask.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
}
