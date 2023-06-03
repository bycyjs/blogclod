package com.bycyjs.login.controller;

import com.bycyjs.login.mapper.UserMapper;
import com.bycyjs.login.pojo.User;
import com.bycyjs.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/login")
@Slf4j
public class LonginController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login() {
        System.out.println("登陆");
//        String forObject = restTemplate.getForObject("http://localhost:8091/user/test", String.class);
        return "登陆";
    }



    @PostMapping("/adduser")
    public String addUser(@RequestBody User user) {

        log.info("数据：" + user);
        if(user.getUsername()==null){
            log.info("user的数据为空");
            return "false";
        }
        user.setTime(new SimpleDateFormat("YYYY-MM-dd HH:MM:ss").format(new Date()));
        String s;
        try {
             s = loginService.addUser(user);
        } catch (Exception e) {
            log.info("报错：" + e);
            return "false";
        }

        return s;
    }

    @PostMapping("/validateUser")
    public String validateUser(@RequestBody User user){

        return loginService.validateUser(user);
    }

    /*图片验证码*/

}
