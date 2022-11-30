package com.soulmatebackend.soulmateuserService.controller;

import com.soulmatebackend.soulmateuserService.domain.User;
import com.soulmatebackend.soulmateuserService.exception.UserAlreadyExistsException;
import com.soulmatebackend.soulmateuserService.exception.UserNotFoundException;
import com.soulmatebackend.soulmateuserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class UserController {
    private UserService userService;
    private ResponseEntity responseEntity;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<User> register(@RequestBody User user) throws UserAlreadyExistsException {
        User savedUser=userService.register(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity userLogin(@RequestBody User user) throws UserNotFoundException {

        try {
            User userObj = userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
            if (userObj.getEmail().equals(user.getEmail()) && userObj.getPassword().equals(user.getPassword()))
                responseEntity = new ResponseEntity(userObj, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>("Customer Saved",HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()  {
        return new ResponseEntity<List<User>>((List<User>) userService .getAllUser(),HttpStatus.OK);

    }

}
