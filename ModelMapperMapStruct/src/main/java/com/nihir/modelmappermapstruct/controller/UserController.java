package com.nihir.modelmappermapstruct.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nihir.modelmappermapstruct.domain.dto.UserDTO;
import com.nihir.modelmappermapstruct.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
