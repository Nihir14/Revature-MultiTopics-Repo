//package com.nihir.springdatajpa.service;
//
//import com.nihir.springdatajpa.entity.User;
//import com.nihir.springdatajpa.repository.UserRepositoryWithPagingAndSorting;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserPagingServiceImpl implements UserPagingService {
//
//    private final UserRepositoryWithPagingAndSorting repository;
//
//    public <UserRepositoryWithPagingAndSorting> UserPagingServiceImpl(UserRepositoryWithPagingAndSorting repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public User saveUser(User user) {
//        return repository.save(user);
//    }
//
//    @Override
//    public Page<User> getUsersByAge(int age, Pageable pageable) {
//        return repository.findByAgeGreaterThan(age, pageable);
//    }
//
//    @Override
//    public Iterable<User> searchUsersByName(String name, Sort sort) {
//        return repository.findByNameContaining(name, sort);
//    }
//}
