//package com.nihir.springdatajpa.controller;
//
//import com.nihir.springdatajpa.entity.User;
//import com.nihir.springdatajpa.service.UserPagingService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users/paging")
//public class UserPagingController {
//
//    private final UserPagingService userService;
//
//    public UserPagingController(UserPagingService userService) {
//        this.userService = userService;
//    }
//
//    // Pagination + Sorting by age
//    @GetMapping("/age")
//    public Page<User> getUsersByAge(
//            @RequestParam int age,
//            @RequestParam int page,
//            @RequestParam int size,
//            @RequestParam(defaultValue = "id") String sortBy
//    ) {
//        return userService.getUsersByAge(
//                age,
//                PageRequest.of(page, size, Sort.by(sortBy))
//        );
//    }
//
//    // Sorting only
//    @GetMapping("/search")
//    public Iterable<User> searchByName(
//            @RequestParam String name,
//            @RequestParam(defaultValue = "name") String sortBy
//    ) {
//        return userService.searchUsersByName(
//                name,
//                Sort.by(sortBy)
//        );
//    }
//}
