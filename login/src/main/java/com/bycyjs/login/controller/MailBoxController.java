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

    @GetMapping("/addMailbox/{mailbox}")
    public R addMailbox(HttpServletRequest request, @PathVariable String mailbox ){
        return mailboxService.addMailbox(request,mailbox);
    }

    @GetMapping("/sendVerificationCode")
    public R sendVerificationCode(HttpServletRequest request){
        return mailboxService.sendVerificationCode(request);
    }


}
