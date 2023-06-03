package com.bycyjs.login.service;

import com.bycyjs.login.pojo.Mailbox;
import com.bycyjs.login.tool.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface MailboxService {
    /*查找账号是否有邮箱*/
    R selectMailbox(Mailbox mailbox);

    /*发送邮箱*/
    R sendVerificationCode(HttpServletRequest request);

    /*添加邮箱*/
    R addMailbox(HttpServletRequest request, String mailbox);
}
