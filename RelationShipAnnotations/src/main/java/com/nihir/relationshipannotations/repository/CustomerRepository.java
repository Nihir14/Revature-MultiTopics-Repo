package com.nihir.relationshipannotations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nihir.relationshipannotations.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
