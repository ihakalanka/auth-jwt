package com.akalanka.authjwt.service;

import com.akalanka.authjwt.entity.User;
import com.akalanka.authjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerivceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}