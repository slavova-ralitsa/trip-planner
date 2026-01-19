package com.example.tripplanner.controller;

import com.example.tripplanner.entity.User;
import com.example.tripplanner.entity.UserDestination;
import com.example.tripplanner.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/current")
    public User getCurrentUser(@RequestParam Long id) {
        return userService.getUserById(id);
    }
}
