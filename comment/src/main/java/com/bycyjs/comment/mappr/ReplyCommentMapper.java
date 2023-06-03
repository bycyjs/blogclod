package com.bycyjs.comment.mappr;

import com.bycyjs.comment.pojo.ReplyComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReplyCommentMapper {
    /*分页查询*/
    @Select("select * from replycomment  limit #{page},#{size}")
    List<ReplyComment> findUserByPage(Map<String, Object> map);

    /*查询表的记录条数*/
    @Select("select count(1) from replycomment")
    long findUserCount();

    @Select("select * from  replycomment where replyusername=${replyusername}")
    List<ReplyComment> selectReply(ReplyComment replyComment);
    /*
    *
    * replycomment:回复的账号
    *
    * */

    @Insert("insert into comment (replyusername,username,content,praise,tread,audit) " +
            "value (#{replyusername},#{username},#{content},#{praise},#{tread},#{audit})")
    void addReply(ReplyComment replyComment);


}
