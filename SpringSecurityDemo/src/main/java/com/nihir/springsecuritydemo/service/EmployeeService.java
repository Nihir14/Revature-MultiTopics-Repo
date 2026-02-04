package com.nihir.springsecuritydemo.service;

import com.nihir.springsecuritydemo.entity.Employee;
import com.nihir.springsecuritydemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee existing = repository.findById(id).orElseThrow();

        existing.setName(employeeDetails.getName());
        existing.setDepartment(employeeDetails.getDepartment());
        existing.setSalary(employeeDetails.getSalary());

        return repository.save(existing);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}