package com.nihir.springsecuritydemo.controller;

import com.nihir.springsecuritydemo.service.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
//@CrossOrigin
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @GetMapping("/home")
    public String home() {
        return "Welcome to Home Page!";
    }


    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user() {
        return "Welcome User!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Welcome Admin!";
    }
}