package com.nihir.hateoasdemo.controller;
 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
 
import java.util.List;
 
import org.springframework.hateoas.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import com.nihir.hateoasdemo.entity.User;
import com.nihir.hateoasdemo.service.UserService;
 
@RestController
@RequestMapping("/users")
public class UserController {
 
    private final UserService service;
 
    public UserController(UserService service) {
        this.service = service;
    }
 
    // CREATE USER
    @PostMapping
    public EntityModel<User> createUser(@RequestBody User user) {
 
        User saved = service.save(user);
 
        return EntityModel.of(saved,
                linkTo(methodOn(UserController.class)
                        .getUserById(saved.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class)
                        .getAllUsers()).withRel("all-users")
        );
    }
 
    // GET USER BY ID (HATEOAS)
    @GetMapping("/{id}")
    public EntityModel<User> getUserById(@PathVariable Long id) {
 
        User user = service.findById(id);
 
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class)
                        .getUserById(id)).withSelfRel(),
                linkTo(methodOn(UserController.class)
                        .getAllUsers()).withRel("all-users"),
                linkTo(methodOn(UserController.class)
                        .deleteUser(id)).withRel("delete")
        );
    }
 
    // GET ALL USERS (COLLECTION HATEOAS)
    @GetMapping
    public CollectionModel<EntityModel<User>> getAllUsers() {
 
        List<EntityModel<User>> users = service.findAll()
                .stream()
                .map(user -> EntityModel.of(user,
                        linkTo(methodOn(UserController.class)
                                .getUserById(user.getId())).withSelfRel()))
                .toList();
 
        return CollectionModel.of(users,
                linkTo(methodOn(UserController.class)
                        .getAllUsers()).withSelfRel());
    }
 
    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}