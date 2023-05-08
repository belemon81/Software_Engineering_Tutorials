package Tut2_3_4.repository;

import Tut2_3_4.model.Employee;
import Tut2_3_4.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContaining(String name);
    List<Employee> findByJobsContaining(Job job);
}
