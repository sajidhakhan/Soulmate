package com.soulmate.service;

import com.soulmate.domain.User;
import com.soulmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    @Override
    public void deleteUser(String email) throws Exception {
        Optional<User> user= userRepository.findById(email);
        if(user.isPresent()){
            this.userRepository.delete(user.get());
        }else{
            throw new Exception("user not found");
        }
    }

    @Override
    public User findByEmail(String email) {
        User user=userRepository.findByEmail(email);
        return user;
    }
}
