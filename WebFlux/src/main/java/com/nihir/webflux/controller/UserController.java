package com.nihir.webflux.controller;

import com.nihir.webflux.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Flux<String> getUsers() {
        return Flux.just("Alice", "Bob", "Charlie");
    }

    @GetMapping("/{id}")
    public Mono<String> getUser(@PathVariable String id) {
        return userService.findUserById(id);
    }
}
