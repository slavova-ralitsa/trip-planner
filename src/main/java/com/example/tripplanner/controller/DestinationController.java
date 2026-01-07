package com.example.tripplanner.controller;

import com.example.tripplanner.entities.User;
import com.example.tripplanner.repositories.DestinationRepository;
import com.example.tripplanner.service.DestinationService;
import com.example.tripplanner.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//http://localhost:8080/hello
@RestController
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{username}")
    public User getByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }


}
