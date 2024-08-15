package com.ormispring.tdddemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void getUserById_존재하는_사용자_조회_성공() {

        User expectedUser = new User(1L, "testUser");
        when(mockUserRepository.findById(1L)).thenReturn(Optional.of(expectedUser));

        User actualUser = userService.getUserById(1L);

        // Then
        assertEquals(expectedUser, actualUser);
        verify(mockUserRepository).findById(1L);
    }

    @Test
    void getUserById_존재하지_않는_사용자_조회_실패() {

        when(mockUserRepository.findById(anyLong())).thenReturn(Optional.empty());

        // When & Then
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(1L));
        verify(mockUserRepository).findById(1L);
    }
}
