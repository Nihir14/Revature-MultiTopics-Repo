package com.nihir.responseentitydemo.repository;

import com.nihir.responseentitydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
