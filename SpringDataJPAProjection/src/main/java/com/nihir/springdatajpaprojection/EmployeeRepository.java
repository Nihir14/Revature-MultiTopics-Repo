package com.nihir.springdatajpaprojection;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Projection method
    List<EmployeeView> findBy();
}
