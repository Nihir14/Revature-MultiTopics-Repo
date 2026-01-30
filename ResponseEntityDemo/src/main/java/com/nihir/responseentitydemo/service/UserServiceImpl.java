package com.nihir.responseentitydemo.service;

import com.nihir.responseentitydemo.entity.User;
import com.nihir.responseentitydemo.exception.UserNotFoundException;
import com.nihir.responseentitydemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User update(Long id, User user) {
        User existing = getById(id);
        existing.setName(user.getName());
        existing.setAge(user.getAge());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
