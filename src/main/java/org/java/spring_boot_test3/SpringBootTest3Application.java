package org.java.spring_boot_test3;

import java.util.List;
import java.util.Optional;

import org.java.spring_boot_test3.db.pojo.Employee;
import org.java.spring_boot_test3.db.serv.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTest3Application
		implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello, World!");

		Employee e1 = new Employee("Guybrush", "Threepwood");
		Employee e2 = new Employee("Elaine", "Marley");
		Employee e3 = new Employee("LeChuck", "Temibile Pirata");

		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);

		employeeService.save(e1);
		employeeService.save(e2);
		employeeService.save(e3);

		System.out.println("------------------------------");

		employeeService.getAllEmployees()
				.forEach(System.out::println);

		System.out.println("------------------------------");

		Optional<Employee> oldEmpOpt = employeeService.getEmployeeById(1);

		if (oldEmpOpt.isEmpty()) {

			System.out.println("Employee not found!");
			return;
		}

		Employee oldEmp = oldEmpOpt.get();
		System.out.println(oldEmp);

		oldEmp.setId(0);
		oldEmp.setName("Mario");
		oldEmp.setSurname("Rossi");

		employeeService.save(oldEmp);
		System.out.println(oldEmp);
	}
}
