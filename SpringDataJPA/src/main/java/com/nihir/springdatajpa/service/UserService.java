package com.nihir.springdatajpa.service;

import com.nihir.springdatajpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    // CRUD
    User saveUser(User user);

    List<User> saveUsers(List<User> users);


    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);

    // Paging & Sorting
    Page<User> getUsersByAge(int age, Pageable pageable);

    Iterable<User> searchUsersByName(String name, Sort sort);
}
