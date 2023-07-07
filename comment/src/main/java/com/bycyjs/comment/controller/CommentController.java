package com.bycyjs.comment.controller;

import com.bycyjs.comment.pojo.Comment;
import com.bycyjs.comment.service.CommentService;
import com.bycyjs.utils.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("findByCommentPager/{page}/{size}")
    public R findByCommentPager(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return commentService.findByCommentPager(page,size);
    }
    @PostMapping("/addComment")
    public   R addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
    @PostMapping("/replyComment")
    public R replyComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping("/setPraise/{id}")
    public R setPraise(@PathVariable("id") Integer id){
        return commentService.setPraise(id);
    }

    @GetMapping("/setTread/{id}")
    public R setTread(@PathVariable("id") Integer id){
        return commentService.setTread(id);
    }



}
