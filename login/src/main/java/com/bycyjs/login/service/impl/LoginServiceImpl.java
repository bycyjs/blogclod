package com.bycyjs.login.service.impl;

import com.bycyjs.login.mapper.UserMapper;
import com.bycyjs.login.pojo.User;
import com.bycyjs.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    /*增加新用户*/
    @Override
    public String addUser(User user) {
        List<User> user1 = null;
        try {
            user1 = userMapper.selectName(user);

        } catch (Exception e) {
            log.info("" + e);
            log.info("fail1");
            return "fail";

        }
        /*判断用户名是否重复*/
        System.out.println(user1.size() > 0);
        if (user1.size() > 0) {
            return "1";
        }
        try {
            userMapper.addUser(user);
        } catch (Exception e) {
            log.info("" + e);
            log.info("fail2");
            return "fail";
        }

        return "succeed";
    }

    /*判断用户是否存在，密码是否正确*/
    @Override
    public String validateUser(User user) {
        List<User> user1 = null;
        /* 判断用户名是否正确*/
        try {
            user1 = userMapper.selectName(user);
        } catch (Exception e) {
            log.info("" + e);
            return "fail";
        }
        if (user1.size() != 1) {
            System.out.println(user);
            System.out.println(user1.size());
            System.out.println(user1);
            return "1";
        }
        /*//判断密码是否正确*/
        User user11 = null;
        try {
            user11 = userMapper.selectPassword(user);
        } catch (Exception e) {
            log.info("" + e);
            return "fail";
        }
        if (user11 == null) {
            log.info(user11 + "");
            return "2";
        }
        return "succeed";
    }
}
