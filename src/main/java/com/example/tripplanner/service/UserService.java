package com.example.tripplanner.service;

import com.example.tripplanner.entity.User;
import com.example.tripplanner.exception.UserAlreadyExistsException;
import com.example.tripplanner.exception.UserNotFoundException;
import com.example.tripplanner.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isEmpty()) {
            return userRepository.save(user);
        } else {
            throw new UserAlreadyExistsException("User already exists!");
        }
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()  -> new UserNotFoundException("No user present with id = " + id));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()  -> new UserNotFoundException("No user present with username = " + username));
    }

    public void deleteUserById(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty())
            throw new UserNotFoundException(("No user present with id = " + id));
        else
            userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty())
            throw new UserNotFoundException(("No user present with id = " + id));
        else {
            user.setId(id);
            return userRepository.save(user);
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
