package com.example.webclientorderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    @Autowired
    private WebClient webClient;

    public Mono<User> getUser(Long userId) {
     return webClient.get()
             .uri("http://localhost:8081/users/{id}",userId)
             .retrieve()
             .bodyToMono(User.class);
    }
}
