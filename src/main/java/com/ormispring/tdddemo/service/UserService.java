package com.ormispring.tdddemo.service;

import com.ormispring.tdddemo.entity.User;

public interface UserService {
    User registerUser(String email, String password, String name);

    User getUserByEmail(String email);

    User updateUser(String email, String name);

    void deleteUser(String email);

    boolean isEmailToken(String email);

    User updateUser(String email, String currentPassword, String newName);

    void deleteUser(String email, String password);
}
