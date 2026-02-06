package com.example.feignclientuserservice;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(id);
        userResponse.setName("amit");
        userResponse.setEmail("amit@gmail.com");

        return userResponse;
    }
}