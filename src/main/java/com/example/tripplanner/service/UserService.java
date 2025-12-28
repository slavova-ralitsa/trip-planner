package com.example.tripplanner.service;

import com.example.tripplanner.entities.User;
import com.example.tripplanner.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
