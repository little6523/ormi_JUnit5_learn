package com.ormispring.tdddemo.controller;

import com.ormispring.tdddemo.entity.User;
import com.ormispring.tdddemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRegistrationDto registrationDto) {
        User newUser =
                userService.registerUser(
                        registrationDto.getEmail(), registrationDto.getPassword(), registrationDto.getName());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable("email") String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(
            @PathVariable("email") String email, @RequestBody UserUpdateDto updateDto) {
        User updatedUser =
                userService.updateUser(email, updateDto.getCurrentPassword(), updateDto.getNewName());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable("email") String email, @RequestBody UserDeleteDto deleteDto) {
        userService.deleteUser(email, deleteDto.getPassword());
        return ResponseEntity.noContent().build();
    }
}