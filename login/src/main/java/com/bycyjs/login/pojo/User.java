package com.bycyjs.login.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private String username;
    private String password;
    private String time;
    private String mailboxvalidate;

}
