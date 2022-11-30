package com.soulmatebackend.controller;

import com.soulmatebackend.domain.User;
import com.soulmatebackend.exception.UserAlreadyExistsException;
import com.soulmatebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

        private UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService=userService;
        }
        @PostMapping("/user")
        public ResponseEntity<User> register(@RequestBody User user) throws UserAlreadyExistsException {
            User savedUser=userService.register(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }

        @GetMapping("/users")
        public ResponseEntity<List<User>> getAllUsers()  {
            return new ResponseEntity<List<User>>((List<User>) userService .getAllUser(),HttpStatus.OK);

        }
}
