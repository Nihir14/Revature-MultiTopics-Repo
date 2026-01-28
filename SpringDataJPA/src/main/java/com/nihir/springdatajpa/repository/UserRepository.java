package com.nihir.springdatajpa.repository;

import com.nihir.springdatajpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByAgeGreaterThan(int age, Pageable pageable);

    // ✅ CASE-INSENSITIVE SEARCH
    Iterable<User> findByNameContainingIgnoreCase(String name, Sort sort);
}
