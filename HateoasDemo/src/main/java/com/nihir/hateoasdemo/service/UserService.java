package com.nihir.hateoasdemo.service;
 
import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.nihir.hateoasdemo.entity.User;
import com.nihir.hateoasdemo.repository.UserRepository;
 
@Service
public class UserService {
 
    private final UserRepository repository;
 
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
 
    public User save(User user) {
        return repository.save(user);
    }
 
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
 
    public List<User> findAll() {
        return repository.findAll();
    }
 
    public void delete(Long id) {
        repository.deleteById(id);
    }
}