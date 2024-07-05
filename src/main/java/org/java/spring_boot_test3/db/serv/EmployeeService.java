package org.java.spring_boot_test3.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_boot_test3.db.pojo.Employee;
import org.java.spring_boot_test3.db.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // OPERAZIONI DI CRUD
    // CREATE
    // READ
    // UPDATE
    // DELETE

    @Autowired
    private EmployeeRepo employeeRepo;

    // READ
    public List<Employee> getAllEmployees() {

        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {

        return employeeRepo.findById(id);
    }

    // CREATE - UPDATE
    public void save(Employee e) {

        employeeRepo.save(e);
    }

    // DELETE
    public void delete(Employee e) {

        employeeRepo.delete(e);
    }
}
