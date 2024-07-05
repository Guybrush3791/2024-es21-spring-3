package org.java.spring_boot_test3.db.repo;

import org.java.spring_boot_test3.db.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
