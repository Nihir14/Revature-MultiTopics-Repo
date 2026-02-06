package com.nihir.swaggerdemo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get User By ID",
            description = "Retrieve user details using user ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User Retrieved"),
            @ApiResponse(responseCode = "404", description = "User not Found")
    })
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


    @PostMapping
    @Operation(
            summary = "Create User",
            description = "Create a new User"
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "404", description = "Invalid input")
    }

    )
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
}
