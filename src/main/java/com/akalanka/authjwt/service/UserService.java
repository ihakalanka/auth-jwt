package com.akalanka.authjwt.service;

import com.akalanka.authjwt.entity.User;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
}
