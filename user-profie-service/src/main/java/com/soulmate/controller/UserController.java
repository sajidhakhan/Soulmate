package com.soulmate.controller;

import com.soulmate.domain.User;
import com.soulmate.service.UserService;
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
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser=userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>>getAllUsers() {
        return new ResponseEntity<List<User>>((List<User>)userService.getAllUsers(), HttpStatus.OK);
    }
    @DeleteMapping("/users/{email}")
    public HttpStatus deleteUser(@PathVariable String email) throws Exception {
        this.userService.deleteUser(email);
        return HttpStatus.OK;
    }
    @GetMapping("/userByEmail/{email}")
    public ResponseEntity<?> userByEmail(@PathVariable String email) {

        User user=userService.findByEmail(email);

        if(user!=null)
            return new ResponseEntity<User>(user,HttpStatus.OK);

        return new ResponseEntity<String>("NotFound",HttpStatus.CONFLICT);
    }
}
