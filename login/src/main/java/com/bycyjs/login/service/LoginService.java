package com.bycyjs.login.service;

import com.bycyjs.login.pojo.User;
import com.bycyjs.utils.common.R;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    R addUser(User user,String code);
    R validateUser(User user, String code);
    /*图片*/
}
