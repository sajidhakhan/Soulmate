package com.soulmatebackend.service;

import com.soulmatebackend.domain.User;
import com.soulmatebackend.exception.UserAlreadyExistsException;

import java.util.List;

public interface UserService {
    User register(User user) throws UserAlreadyExistsException;
    public List<User> getAllUser() ;

}
