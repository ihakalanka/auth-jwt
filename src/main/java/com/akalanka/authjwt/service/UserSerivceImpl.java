package com.akalanka.authjwt.service;

import com.akalanka.authjwt.entity.User;
import com.akalanka.authjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSerivceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<User> findByEmail(User user){
        User isExistUser = userRepository.findByEmail(user.getEmail());
        if(isExistUser == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(isExistUser);
    }
}