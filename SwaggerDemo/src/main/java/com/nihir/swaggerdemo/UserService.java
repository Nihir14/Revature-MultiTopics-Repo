package com.nihir.swaggerdemo;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(Long id) {
        if (id == 0) {
            throw new IllegalArgumentException("User Not Found");
        }
        return new User(id, "Nihir");
    }

    public User createUser(User user) {
        user.setId(1L);
        return user;
    }
}
