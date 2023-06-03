package com.bycyjs.comment.pojo;

import lombok.Data;

@Data
public class ReplyComment {
    private Integer id;
    private String username;
    private String time;
    /*回复谁的评论*/
    private String replyusername;
    /*评论内容*/
    private String content;
    /*点赞*/
    private Integer praise;
    /*踩*/
    private Integer tread;
    /*验证评论是否合法*/
    private Integer audit;
}
