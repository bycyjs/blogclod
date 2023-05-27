package com.bycyjs.service.web;

import com.bycyjs.service.bojo.User;
import com.bycyjs.service.tool.HttpEntityTool;
import com.bycyjs.service.tool.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/userservice")
@RestController
@Slf4j
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


    @PostMapping("/validateUser")
    public R validateUser(@RequestBody User user) throws Exception {
        HttpEntity httpEntity1 = httpEntity.objPost(user);
        String url = "http://login/login/validateUser";
        String s = restTemplate.postForObject(url, httpEntity1, String.class);
        if ("fail".equals(s)) {
            return R.success("出错");
        } else if ("1".equals(s)) {
            return R.error("用户名不存在");
        }else if("2".equals(s)){
            return R.error("密码错误");
        }else if ("succeed".equals(s)){
            return R.success("succeed");
        }else {
            return R.error("未知错误");
        }
    }
}
