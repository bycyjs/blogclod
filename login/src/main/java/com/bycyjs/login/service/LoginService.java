package com.bycyjs.login.service;

import com.bycyjs.login.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    String addUser(User user);
    String validateUser(User user);
}
