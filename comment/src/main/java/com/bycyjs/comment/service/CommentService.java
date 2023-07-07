package com.bycyjs.comment.service;

import com.bycyjs.comment.pojo.Comment;
import com.bycyjs.utils.common.R;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    R findByCommentPager(Integer page, Integer size);

    R addComment(Comment comment);

    /*查找追评*/
    R replyComment(Comment comment);

    /*设置点赞的数量*/
    R  setPraise(Integer id);

    R setTread(Integer id);

}
