package com.akalanka.authjwt.controller;

import com.akalanka.authjwt.entity.User;
import com.akalanka.authjwt.service.UserSerivceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserSerivceImpl userSerivce;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userSerivce.save(user);
    }

    @PostMapping ("/getUser")
    public ResponseEntity<User> getUser(@RequestBody User user) throws UsernameNotFoundException {
        return userSerivce.findByEmail(user);
    }
}
