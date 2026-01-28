package com.nihir.webflux.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    public Mono<String> findUserById(String id) {
        return Mono.just("User Id : " + id);
    }
}
