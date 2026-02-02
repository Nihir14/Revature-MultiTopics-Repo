package com.nihir.hateoasdemo.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.nihir.hateoasdemo.entity.User;
 
public interface UserRepository extends JpaRepository<User, Long> {
}