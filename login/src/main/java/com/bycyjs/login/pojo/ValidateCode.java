package com.bycyjs.login.pojo;

import lombok.Data;

@Data
public class ValidateCode {
    private String mailbox;
    private String time;
    private String code;
}
