package com.nihir.modelmappermapstruct.service;

import java.util.List;
import com.nihir.modelmappermapstruct.domain.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
}
