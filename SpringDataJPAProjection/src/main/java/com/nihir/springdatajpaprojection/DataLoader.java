package com.nihir.springdatajpaprojection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository) {

        return args -> {

            Department it = new Department();
            it.setName("IT");

            Department hr = new Department();
            hr.setName("HR");

            departmentRepository.save(it);
            departmentRepository.save(hr);

            Employee e1 = new Employee();
            e1.setName("Nihir");
            e1.setSalary(50000);
            e1.setDepartment(it);

            Employee e2 = new Employee();
            e2.setName("Aman");
            e2.setSalary(40000);
            e2.setDepartment(hr);

            employeeRepository.save(e1);
            employeeRepository.save(e2);
        };
    }
}
