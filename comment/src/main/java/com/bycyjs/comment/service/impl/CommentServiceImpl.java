package com.bycyjs.comment.service.impl;

import com.bycyjs.comment.mappr.CommentMapper;
import com.bycyjs.comment.mappr.ReplyCommentMapper;
import com.bycyjs.comment.model.Pager;
import com.bycyjs.comment.pojo.Comment;
import com.bycyjs.comment.pojo.ReplyComment;
import com.bycyjs.comment.service.CommentService;
import com.bycyjs.utils.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public R findByCommentPager(Integer page, Integer size) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", (page - 1) * size);
        params.put("size", size);
        List<Comment> list = commentMapper.findByCommentPager(params);
        Pager<Comment> pager = new Pager<Comment>();
        pager.setData(list);
        pager.setTotal(commentMapper.findUCommentCount());
        return R.success(pager);
    }

    @Override
    public R addComment(Comment comment) {
        if (comment == null) {
            log.error("comment为空");
            return R.error("comment为空");
        }
        comment.setTime(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        comment.setTread(0);
        comment.setAudit(0);
        comment.setPraise(0);
        try {
            commentMapper.addComment(comment);
        } catch (Exception e) {
            log.error("1" + e);
            return R.error("1" + e);
        }
        return R.success("success");
    }
    @Autowired
    private ReplyCommentMapper replyCommentMapper;

    @Override
    public R replyComment(Comment comment) {
        ReplyComment replyComment=new ReplyComment();
        replyComment.setReplyusername(comment.getUsername());
        List<ReplyComment> replyComments=null;
        try{
            replyComments = replyCommentMapper.selectReply(replyComment);
        }catch (Exception e){
            log.error(""+e);
            return R.error(""+e);
        }

//        replyCommentMapper.selectReply();
        return R.success(replyComments);
    }

    @Override
    public R setPraise(Integer id) {
        Comment comment1 = commentMapper.selectPraise(id);
        Integer praise = comment1.getPraise();
        praise++;
        comment1.setPraise(praise);
        commentMapper.setPraise(comment1);

        return R.success("success");
    }

    @Override
    public R setTread(Integer id) {
        Comment comment = commentMapper.selectPraise(id);
        Integer tread = comment.getTread();
        tread++;
        comment.setTread(tread);
        commentMapper.setTread(comment);
        return R.success("success");
    }
}
