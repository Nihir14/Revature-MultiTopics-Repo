package com.nihir.springdatajpa.controller;

import com.nihir.springdatajpa.entity.User;
import com.nihir.springdatajpa.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ===================== CREATE =====================

    // CREATE SINGLE USER
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // CREATE MULTIPLE USERS (BULK - manual logic in service)
    @PostMapping("/bulk")
    public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users) {
        List<User> savedUsers = userService.saveUsers(users);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }

    // ===================== READ =====================

    // READ ALL USERS
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // READ USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user != null
                ? ResponseEntity.ok(user)
                : ResponseEntity.notFound().build();
    }

    // ===================== DELETE =====================

    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    // ===================== PAGING & SORTING =====================

    // PAGINATION + SORTING BY AGE
    @GetMapping("/paging/age")
    public ResponseEntity<Page<User>> getUsersByAge(
            @RequestParam int age,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<User> users = userService.getUsersByAge(
                age,
                PageRequest.of(page, size, Sort.by(sortBy))
        );
        return ResponseEntity.ok(users);
    }

    // SEARCH BY NAME (CASE-INSENSITIVE) + SORTING
    @GetMapping("/paging/search")
    public ResponseEntity<Iterable<User>> searchByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        Iterable<User> users =
                userService.searchUsersByName(name, Sort.by(sortBy));
        return ResponseEntity.ok(users);
    }
}
