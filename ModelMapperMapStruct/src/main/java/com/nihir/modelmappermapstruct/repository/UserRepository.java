package com.nihir.modelmappermapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nihir.modelmappermapstruct.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
