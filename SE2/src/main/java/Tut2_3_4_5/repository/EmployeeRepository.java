package Tut2_3_4_5.repository;

import Tut2_3_4_5.model.Employee;
import Tut2_3_4_5.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContaining(String name);

    List<Employee> findByJobsContaining(Job job);
}
