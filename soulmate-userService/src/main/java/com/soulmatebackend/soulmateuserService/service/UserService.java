package com.soulmatebackend.soulmateuserService.service;

import com.soulmatebackend.soulmateuserService.domain.User;
import com.soulmatebackend.soulmateuserService.exception.UserAlreadyExistsException;
import com.soulmatebackend.soulmateuserService.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User register(User user) throws UserAlreadyExistsException;
    User saveUser(User user);
    User findUserByEmailAndPassword(String email,String password) throws UserNotFoundException;
    public List<User> getAllUser() ;
}
