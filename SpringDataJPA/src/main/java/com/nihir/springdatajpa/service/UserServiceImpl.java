package com.nihir.springdatajpa.service;

import com.nihir.springdatajpa.entity.User;
//import com.nihir.springdatajpa.repository.UserRepositoiryWithPagingAndSorting;
import com.nihir.springdatajpa.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    // ================= CRUD =================

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> saveUsers(List<User> users) {

        // Map to ensure uniqueness by email
        Map<String, User> uniqueUsersMap = new HashMap<>();

        for (User user : users) {
            // put() will overwrite duplicates → ensures uniqueness
            uniqueUsersMap.put(user.getEmail(), user);
        }

        List<User> savedUsers = new ArrayList<>();

        for (User user : uniqueUsersMap.values()) {

            // check DB to avoid existing email
            boolean exists = repository
                    .findByNameContainingIgnoreCase(user.getEmail(), Sort.unsorted())
                    .iterator()
                    .hasNext();

            if (!exists) {
                savedUsers.add(repository.save(user));
            }
        }

        return savedUsers;
    }


    @Override
    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    // ============== PAGING & SORTING ==============

    @Override
    public Page<User> getUsersByAge(int age, Pageable pageable) {
        return repository.findByAgeGreaterThan(age, pageable);
    }

    @Override
    public Iterable<User> searchUsersByName(String name, Sort sort) {
        return repository.findByNameContainingIgnoreCase(name, sort);
    }
}
