package com.bycyjs.comment.mappr;

import com.bycyjs.comment.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {

    /*分页查询*/
    @Select("select  * from comment limit #{page},#{size}")
    List<Comment> findByCommentPager(Map<String, Object> map);

    /*查询表的记录条数*/
    @Select("select count(1) from comment")
    long findUCommentCount();


    /*
    * username:用户名
    * content：发表的内容
    * praise：点赞数量
    * tread：踩的数量
    * audit：是否经过审核，0为不通过，1为通过，2为未审核
    * */
    @Insert("insert into comment(username,content,praise,tread,audit,time)" +
            " value (#{username},#{content},#{praise},#{tread},#{audit},#{time})")
    void addComment(Comment comment);

    @Select("select * from comment where id=#{id} ")
    Comment selectPraise(Integer id);
    @Update("update comment set praise=#{praise} where id=#{id}")
    void setPraise(Comment comment);
    @Update("update comment set tread=#{tread} where id=#{id}")
    void setTread(Comment comment);


}
