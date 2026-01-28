package com.nihir.springrev.repository;

import com.nihir.springrev.model.User;
import org.springframework.stereotype.Repository;

public interface UserRepository {
    User findById(int id);
}
