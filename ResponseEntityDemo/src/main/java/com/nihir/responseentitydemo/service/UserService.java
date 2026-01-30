package com.nihir.responseentitydemo.service;

import com.nihir.responseentitydemo.entity.User;
import java.util.List;

public interface UserService {

    User save(User user);
    User getById(Long id);
    List<User> getAll();
    User update(Long id, User user);
    void delete(Long id);
}
