package com.nihir.webflux.controller;

import com.nihir.webflux.entity.User;
import com.nihir.webflux.service.UserService1;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users1")
public class UserController1 {
    private final UserService1 userService1;

    public UserController1(UserService1 userService1) {
        this.userService1 = userService1;
    }

    @PostMapping
    public Mono<User> create(@RequestBody User user) {
        return userService1.save(user);
    }

    @GetMapping
    public Flux<User> findAll() {
        return userService1.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable Integer id) {
        return userService1.findById(id);
    }

    @GetMapping("/name/{name}")
    public Flux<User> findByName(@PathVariable String name) {
        return userService1.findByName(name);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) {
        return userService1.deleteById(id);
    }


}
