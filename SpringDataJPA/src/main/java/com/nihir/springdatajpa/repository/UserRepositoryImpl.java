//package com.nihir.springdatajpa.repository;
//
//import com.nihir.springdatajpa.entity.User;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface UserRepositoryImpl extends UserRepository {
//
//    Page<User> findByAgeGreaterThan(int age, Pageable pageable);
//
//    Iterable<User> findByNameContaining(String name, Sort sort);
//}
