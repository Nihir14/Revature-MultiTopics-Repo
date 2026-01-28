package com.nihir.webflux.repository;

import com.nihir.webflux.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
    Flux<User> findByName(String name);
}
