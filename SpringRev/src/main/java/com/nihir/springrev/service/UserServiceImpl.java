package com.nihir.springrev.service;

import com.nihir.springrev.model.User;
import com.nihir.springrev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }
}
