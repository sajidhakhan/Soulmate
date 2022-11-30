package com.soulmatebackend.soulmateuserService.service;

import com.soulmatebackend.soulmateuserService.domain.User;
import com.soulmatebackend.soulmateuserService.exception.UserAlreadyExistsException;
import com.soulmatebackend.soulmateuserService.exception.UserNotFoundException;
import com.soulmatebackend.soulmateuserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) throws UserAlreadyExistsException {
        return userRepository.save(user);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) throws UserNotFoundException {
        User user =  userRepository.findUserByEmailAndPassword(email , password);
        if(user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }
}
