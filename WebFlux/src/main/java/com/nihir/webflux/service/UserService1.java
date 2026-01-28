package com.nihir.webflux.service;

import com.nihir.webflux.entity.User;
import com.nihir.webflux.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService1 {
    private final UserRepository userRepository;

    public UserService1(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public Flux<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public Mono<Void> deleteById(Integer id) {
        return userRepository.deleteById(id);
    }



}
