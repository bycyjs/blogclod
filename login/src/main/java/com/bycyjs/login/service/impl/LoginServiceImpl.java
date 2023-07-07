package com.bycyjs.login.service.impl;

import com.bycyjs.login.mapper.CodeMapper;
import com.bycyjs.login.mapper.MailboxMapper;
import com.bycyjs.login.mapper.UserMapper;
import com.bycyjs.login.pojo.User;
import com.bycyjs.login.service.LoginService;
import com.bycyjs.login.service.MailboxService;
import com.bycyjs.utils.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MailboxService mailboxService;
    @Autowired
    private CodeMapper codeMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /*增加新用户*/
    @Override
    public R addUser(User user,String code) {
        List<User> user1 = null;
        try {
            user1 = userMapper.selectName(user);

        } catch (Exception e) {
            log.error("" + e);
            log.error("fail1");
            return R.error("出错了");

        }
        /*判断用户名是否重复*/
        /*System.out.println(user1.size() > 0);*/
        if (user1.size() > 0) {
            return R.error("用户名重复");
        }
        try {
            userMapper.addUser(user);
            mailboxService.addMailboxlogin(user.getUsername(), user.getMailboxvalidate(),code);
        } catch (Exception e) {
            log.error("" + e);
            log.error("fail2");
            return R.error("出错了");

        }

        return R.success("success");
    }

    /*判断用户是否存在，密码是否正确*/
    @Override
    public R validateUser(User user,String code) {
        List<User> user1 = null;
        /* 判断用户名是否正确*/
        try {
            user1 = userMapper.selectName(user);
        } catch (Exception e) {
            log.error("" + e);
           return R.error("出错了") ;
        }
        if (user1.size() != 1) {
            return R.error( "用户名不存在");
        }
        /*//判断密码是否正确*/
        User user11 = null;
        try {
            user11 = userMapper.selectPassword(user);
        } catch (Exception e) {
            log.error("" + e);
            return R.error("出错了");
        }
        if (user11 == null) {
            log.info(user11 + "");
            return R.error( "密码错误");
        }
        String code1=redisTemplate.opsForValue().get(user.getUsername());
       if (code1!=null){
           if (code1.equals(code)){
               return  R.success("succeed");
           }else {
               return R.error("验证码错误") ;
           }
       }else {
           return R.error("请获取验证码");
       }

    }
}
