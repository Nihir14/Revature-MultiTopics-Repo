package com.nihir.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ReactiveController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello from reactive controller");
    }
}
