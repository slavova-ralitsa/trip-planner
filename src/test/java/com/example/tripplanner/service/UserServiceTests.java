package com.example.tripplanner.service;

import com.example.tripplanner.entity.User;
import com.example.tripplanner.exception.UserAlreadyExistsException;
import com.example.tripplanner.exception.UserNotFoundException;
import com.example.tripplanner.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User createFirstTestUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("ralitsa_sl");
        return user;
    }

    private User createSecondTestUser() {
        User user = new User();
        user.setId(2L);
        user.setUsername("ivailo_gr");
        return user;
    }

    @Test
    void createUser_validInput_returnsSavedUser() {
        User user = createFirstTestUser();

        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.createUser(user);

        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals("ralitsa_sl", result.getUsername());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void createUser_invalidInput_throwsUserAlreadyExistsException() {
        User user = createFirstTestUser();

        when(userRepository.findByUsername("ralitsa_sl")).thenReturn(Optional.of(user));

        assertThrows(UserAlreadyExistsException.class, () -> {
            userService.createUser(user);
        });
        verify(userRepository, times(0)).save(any(User.class));
    }

    @Test
    void getUserById_validId_returnsUser() {
        User user = createFirstTestUser();

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("ralitsa_sl", result.getUsername());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void getUserById_invalidId_throwsUserNotFoundException() {
        when(userRepository.findById(-1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> {userService.getUserById(-1L);});
        verify(userRepository, times(1)).findById(-1L);
    }

    @Test
    void getUserByUsername_validUsername_returnsUser() {
        User user = createFirstTestUser();

        when(userRepository.findByUsername("ralitsa_sl")).thenReturn(Optional.of(user));

        User result = userService.getUserByUsername("ralitsa_sl");

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("ralitsa_sl", result.getUsername());
        verify(userRepository, times(1)).findByUsername("ralitsa_sl");
    }

    @Test
    void getUserByUsername_invalidUsername_throwsUserNotFoundException() {
        when(userRepository.findByUsername("")).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> {userService.getUserByUsername("");});
        verify(userRepository, times(1)).findByUsername("");
    }

    @Test
    void updateUser_validId_updatesUser() {
        long userId = 1L;

        User user = createFirstTestUser();

        User newUser = createSecondTestUser();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User updatedUser = userService.updateUser(userId, newUser);

        assertNotNull(updatedUser);
        assertEquals(userId, updatedUser.getId());
        assertEquals("ivailo_gr", updatedUser.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void updateUser_invalidId_throwsUserNotFoundException() {
        long userId = 1L;

        User user = createSecondTestUser();
        when(userRepository.findById(userId)).thenReturn((Optional.empty()));

        assertThrows(UserNotFoundException.class, () -> {userService.updateUser(userId, user);});
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(0)).save(any(User.class));
    }

    @Test
    void deleteUserById_invalidId_deletesUser() {
        User user = createSecondTestUser();

        when(userRepository.findById(2L)).thenReturn(Optional.of(user));
        userService.deleteUserById(2L);
        verify(userRepository, times(1)).deleteById(2L);
    }

    @Test
    void deleteUserById_invalidId_throwsUserNotFoundException() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> {userService.deleteUserById(2L);});

        verify(userRepository).findById(2L);
        verify(userRepository, times(0)).deleteById(2L);
    }

    @Test
    void findAll_returnsAllUsers() {
        User user1 = createFirstTestUser();
        User user2 = createSecondTestUser();

        List<User> users = List.of(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.findAll();

        assertEquals(2, result.size());
        assertEquals(users, result);

        verify(userRepository, times(1)).findAll();
    }

}
