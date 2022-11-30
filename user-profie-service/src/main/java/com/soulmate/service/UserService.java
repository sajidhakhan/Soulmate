package com.soulmate.service;

import com.soulmate.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    void deleteUser(String email) throws Exception;
    User findByEmail(String email);
}
