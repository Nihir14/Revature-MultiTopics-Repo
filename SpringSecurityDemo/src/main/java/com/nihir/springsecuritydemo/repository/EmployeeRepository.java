package com.nihir.springsecuritydemo.repository;

import com.nihir.springsecuritydemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
