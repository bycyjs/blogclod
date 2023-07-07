package com.bycyjs.login.service.impl;

import com.bycyjs.login.mapper.MailboxMapper;
import com.bycyjs.login.mapper.UserMapper;
import com.bycyjs.login.pojo.Mailbox;
import com.bycyjs.login.pojo.User;
import com.bycyjs.login.service.MailboxService;
import com.bycyjs.login.tool.VerificationCode;
import com.bycyjs.utils.common.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class MailboxServiceImpl implements MailboxService {

    @Autowired
    private MailboxMapper mailboxMapper;

    @Autowired
    private JavaMailSender mailSender;

    /*判断是否存有邮箱*/
    @Override
    public R selectMailbox(Mailbox mailbox) {
        Mailbox mailbox1 = null;
        try {
            mailbox1 = mailboxMapper.selectMailbox(mailbox);
        } catch (Exception e) {
            log.info("selectMailbox:" + e);
            return R.error("" + e);
        }
        if (mailbox1 == null) {
            return R.error("fail");
        } else {
            return R.success(mailbox1);
        }

    }


    /*发送验证码*/
    //	获得发件人信息
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public R sendVerificationCode(HttpServletRequest request) {

        Mailbox mailbox = new Mailbox();
        mailbox.setUsername(request.getHeader("username"));


        /*判断账号是否绑定的有邮箱*/
        R r = selectMailbox(mailbox);
        if (r.getCode() == 1) {
           mailbox= mailboxMapper.selectMailbox(mailbox);
            /*获取一个验证码*/
            VerificationCode code = new VerificationCode();
            String vcode = code.verificationCode();
            SimpleMailMessage message = new SimpleMailMessage();
            /*// 发件箱*/
            message.setFrom(from);
            /*// 收件箱可以是多个，用 String[] 表示多个收件箱*/
            message.setTo(mailbox.getMailbox());
            /* // 邮件主题*/
            message.setSubject("你本次的验证码是");
            /*邮件内容*/
            message.setText("尊敬的" + mailbox.getUsername() + ",您好:\n"
                    + "\n本次请求的邮件验证码为:" + vcode + ",本验证码 5 分钟内效，请及时输入。（请勿泄露此验证码）\n"
                    + "\n如非本人操作，请忽略该邮件。\n(这是一封通过自动发送的邮件，请不要直接回复）");
            /*System.out.println(message.getFrom());*/
            try {
                mailSender.send(message);
            } catch (Exception e) {
                log.error("" + e);
                return R.error("" + e);
            }

            return R.success(vcode);
        }
        return R.error("发送失败");
    }

    @Autowired
    private UserMapper userMapper;

    /*绑定邮箱*/
    @Override
    public R addMailbox(HttpServletRequest request, String mailbox) {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (userMapper.selectName(user) != null) {
            if (userMapper.selectPassword(user) != null) {
                String time = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
                Mailbox mailbox1 = new Mailbox();
                mailbox1.setMailbox(mailbox);
                mailbox1.setUsername(username);
                mailbox1.setAltertime(time);

                if (mailboxMapper.selectMailbox(mailbox1) != null) {
                    return R.error("已经有邮箱");
                }
                try {
                    mailboxMapper.addMailbox(mailbox1);
                } catch (Exception e) {
                    log.info("" + e);
                    return R.error("邮箱添加失败");
                }
                return R.success("邮箱添加成功");

            } else {
                return R.error("密码错误");
            }
        } else {
            return R.error("账号不存在");
        }


    }

    @Override
    public R addMailboxlogin(String username, String mailbox) {
        Mailbox mailbox1=new Mailbox();
        mailbox1.setMailbox(mailbox);
        mailbox1.setAltertime(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
        mailbox1.setUsername(username);
        mailboxMapper.addMailbox(mailbox1);
        return null;
    }

    @Override
    public R sendVerificationCodelogin(String mailbox) {
        VerificationCode code = new VerificationCode();
        String vcode = code.verificationCode();
        SimpleMailMessage message = new SimpleMailMessage();
        /*// 发件箱*/
        message.setFrom(from);
        /*// 收件箱可以是多个，用 String[] 表示多个收件箱*/
        message.setTo(mailbox);
        /* // 邮件主题*/
        message.setSubject("你本次的验证码是");
        /*邮件内容*/
        message.setText("尊敬的" +mailbox + ",您好:\n"
                + "\n本次请求的邮件验证码为:" + vcode + ",本验证码 5 分钟内效，请及时输入。（请勿泄露此验证码）\n"
                + "\n如非本人操作，请忽略该邮件。\n(这是一封通过自动发送的邮件，请不要直接回复）");
        /*System.out.println(message.getFrom());*/
        try {
            mailSender.send(message);
        } catch (Exception e) {
            log.error("" + e);
            return R.error("" + e);
        }
        return R.success(vcode);
    }


}
