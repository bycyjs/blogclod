package com.bycyjs.login.tool;


import com.bycyjs.login.pojo.ValidateCode;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ValidateCodeTool {


    /*判断验证码时间是否过期*/
    public Boolean validateCodeExpire(ValidateCode code){

        long time=5*60*1000;
        long nowTime= System.currentTimeMillis();

        long codeTime= Long.parseLong(code.getTime());

        time+=codeTime;
        return time < nowTime;

    }
}
