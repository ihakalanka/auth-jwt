package com.akalanka.authjwt.controller;

import com.akalanka.authjwt.entity.JwtRequest;
import com.akalanka.authjwt.entity.User;
import com.akalanka.authjwt.repository.UserRepository;
import com.akalanka.authjwt.service.UserSerivceImpl;
import com.akalanka.authjwt.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSerivceImpl userSerivce;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        String password = user.getPassword();
        password = passwordEncoder.encode(password);
        user.setPassword(password);
        return userSerivce.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Map> loginUser(@RequestBody JwtRequest jwtRequest) {
        
    }

    public boolean verifyUser(JwtRequest jwtRequest) {
        boolean isVerified = false;
        User user = userRepository.findByEmail(jwtRequest.getUsername());
        if(passwordEncoder.matches(jwtRequest.getPassword(), user.getPassword())){
            isVerified = true;
        }
        return isVerified;
    }

    @PostMapping ("/getUser")
    public User getUser(@RequestBody User user) {
        return userSerivce.findByEmail(user);
    }
}
