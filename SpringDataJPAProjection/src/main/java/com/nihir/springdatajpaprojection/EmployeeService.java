package com.nihir.springdatajpaprojection;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeView> getEmployeeProjection() {
        return employeeRepository.findBy();
    }
}
