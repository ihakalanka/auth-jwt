package com.akalanka.authjwt.service;

import com.akalanka.authjwt.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User save(User user);
    ResponseEntity<User> findByEmail(User user);
}
