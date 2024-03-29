package com.bycyjs.service.web;

import com.bycyjs.utils.common.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mailboxService")
public class MailboxController {

    @Autowired
    private RestTemplate restTemplate;
    /*绑定邮箱*/
    @GetMapping("/addMailbox/{mailbox}/{code}")
    public R addMailbox(HttpServletRequest request, @PathVariable String mailbox,@PathVariable("code")String code){
        org.springframework.http.HttpHeaders headers=new HttpHeaders();
        headers.add("username",request.getHeader("username"));
        headers.add("password",request.getHeader("password"));
        String url="http://login/mailbox/addMailbox/"+mailbox+"/"+code;
        HttpEntity http=new HttpEntity(headers);
        ResponseEntity<R> exchange = restTemplate.exchange(url, HttpMethod.GET, http, R.class);
        return exchange.getBody();
    }

//    @GetMapping("/validate/{username}")
//    public R validate(HttpServletRequest request,@PathVariable String username){
//
//    }


    @GetMapping("/sendVerificationCode")
    public R sendVerificationCode(HttpServletRequest request){

        HttpHeaders headers=new HttpHeaders();
        headers.add("username",request.getHeader("username"));
        String url="http://login/mailbox/sendVerificationCode";
        HttpEntity http=new HttpEntity(headers);
        ResponseEntity<R> exchange = restTemplate.exchange(url, HttpMethod.GET, http, R.class);
        return exchange.getBody();

    }

}
