package com.bycyjs.service.bojo;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private String username;
    private String time;
    /*评论内容*/
    private String content;
    /*点赞*/
    private Integer praise;
    /*踩*/
    private Integer tread;
    /*验证评论是否合法*/
    private Integer audit;

}
