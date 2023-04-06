package com.springboot.service;

import java.util.List;

import com.springboot.ENUM.UserRole;
import com.springboot.model.User;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
    List<User> findAll();
    void updateUserRole(Long userId, UserRole role);
}