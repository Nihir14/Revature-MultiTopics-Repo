package com.nihir.springdatajpaprojection;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/projection")
    public List<EmployeeView> getEmployeeProjection() {
        return employeeService.getEmployeeProjection();
    }
}
