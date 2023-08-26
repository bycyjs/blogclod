package com.bycyjs.comment.pojo;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private String username;
    private String time;
    private String content;
    private Integer praise;
    private Integer tread;
    private Integer audit;

}
