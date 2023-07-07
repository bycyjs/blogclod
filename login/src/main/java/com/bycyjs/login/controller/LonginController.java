package com.bycyjs.login.controller;

import com.bycyjs.login.mapper.UserMapper;
import com.bycyjs.login.pojo.User;
import com.bycyjs.login.service.LoginService;
import com.bycyjs.login.service.MailboxService;
import com.bycyjs.utils.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    private MailboxService mailboxService;

    @RequestMapping("/login")
    public String login() {
        System.out.println("登陆");
//        String forObject = restTemplate.getForObject("http://localhost:8091/user/test", String.class);
        return "登陆";
    }


    @PostMapping("/adduser/{code}")
    public R addUser(@RequestBody User user,@PathVariable("code")String code) {


        /*log.info("数据：" + user);*/
        if (user.getUsername() == null) {
            log.error("user的数据为空");
            return R.error("请输入用户数据");
        }
        user.setTime(new SimpleDateFormat("YYYY-MM-dd HH:MM:ss").format(new Date()));
        R s;
        try {
            s = loginService.addUser(user,code);

        } catch (Exception e) {
            log.error("报错：" + e);
            return R.error("注册用户失败");
        }


        return s;
    }

    /*验证用户登陆*/
    @PostMapping("/validateUser/{code}")
    public R validateUser(@RequestBody User user,@PathVariable("code") String code) {

        return loginService.validateUser(user,code);
    }

    /*图片验证码*/

    /*注册验证码*/
   @GetMapping("/sendVerificationCodelogin/{mailbox}")
    public R SendVerificationCodeLogin(@PathVariable("mailbox" ) String mailbox){
       return mailboxService.sendVerificationCodelogin(mailbox);
   }

}
