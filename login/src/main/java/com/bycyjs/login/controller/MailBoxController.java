package com.bycyjs.login.controller;

import com.bycyjs.login.service.MailboxService;
import com.bycyjs.utils.common.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mailbox")
public class MailBoxController {


    @Autowired
    private MailboxService mailboxService;

    @GetMapping("/addMailbox/{mailbox}/{code}")
    public R addMailbox(HttpServletRequest request, @PathVariable String mailbox ,@PathVariable("code") String code){
        return mailboxService.addMailbox(request,mailbox,code);
    }

    @GetMapping("/sendVerificationCode")
    public R sendVerificationCode(HttpServletRequest request){
        return mailboxService.sendVerificationCode(request);
    }


}
