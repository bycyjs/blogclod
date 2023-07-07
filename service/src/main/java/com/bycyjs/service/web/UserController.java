package com.bycyjs.service.web;

import com.bycyjs.service.bojo.User;
import com.bycyjs.service.config.Cyclostyle;
import com.bycyjs.utils.common.HttpEntityTool;
import com.bycyjs.utils.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequestMapping("/userservice")
@RestController
@Slf4j
@RefreshScope
public class UserController {

    @Autowired
    private RestTemplate restTemplate;


    private HttpEntityTool httpEntity = new HttpEntityTool();

    @PostMapping("/login")
    public R logIn(@RequestBody User user) throws Exception {
        HttpEntity httpEntity1 = httpEntity.objPost(user);
        String url = "http://login/login/adduser";
        String validate = null;
        try {
            validate = restTemplate.postForObject(url, httpEntity1, String.class);
        } catch (Exception e) {
            log.info("" + e);
            return R.error("用户注册失败");
        }
        log.info(validate);
        if ("fail".equals(validate)) {
            return R.error("出错");
        } else if ("1".equals(validate)) {
            return R.error("用户名已存在");
        } else if ("succeed".equals(validate)) {
            return R.success(validate);
        } else {
            log.info(validate);
            return R.success("未知错误");
        }


    }


    @PostMapping("/validateUser/{code}")
    public R validateUser(@RequestBody User user,@PathVariable("code") String code) throws Exception {

        HttpEntity httpEntity1 = httpEntity.objPost(user);
        String url = "http://login/login/validateUser/"+code;
        R r = restTemplate.postForObject(url, httpEntity1, R.class);
        /*if ("fail".equals(s)) {
            return R.success("出错");
        } else if ("1".equals(s)) {
            return R.error("用户名不存在");
        }else if("2".equals(s)){
            return R.error("密码错误");
        }else if ("succeed".equals(s)){
            return R.success("succeed");
        }else {
            return R.error("未知错误");
        }*/
        return r;
    }


    /*测试*/
/*//    @Value("${pattern.dateformat}")
//    private String dateformat;*/
    @Autowired
    private Cyclostyle cyclostyle;
    @GetMapping("/dateformat")
    public String dateformat(){
        return  LocalDateTime.now().format(DateTimeFormatter.ofPattern(cyclostyle.getDateformat()));
    }
    @GetMapping("/sendVerificationCodelogin/{mailbox}")
    public R  SendVerificationCodeLogin(@PathVariable("mailbox" ) String mailbox){
        String url ="http://login/login/sendVerificationCodelogin/"+mailbox;

        return restTemplate.getForObject(url,R.class);
    }
}
