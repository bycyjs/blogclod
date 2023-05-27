package com.bycyjs.login.mapper;

import com.bycyjs.login.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {

    @Insert("insert into user value (#{username},#{password},#{time})")
    void addUser(User user);

    /*查找用户是否存在*/
    @Select("select * from user where username=#{username}")
     List<User> selectName(User user);

    /*查找用户密码是否正确*/
    @Select("select * from user where username=#{username} and password=#{password}")
    User selectPassword(User user);
}
