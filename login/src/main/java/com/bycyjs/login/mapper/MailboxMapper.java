package com.bycyjs.login.mapper;

import com.bycyjs.login.pojo.Mailbox;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MailboxMapper {

    @Select("select * from mailbox where username=#{username}")
    Mailbox selectMailbox(Mailbox mailbox);

    @Insert("insert into mailbox (username,mailbox,altertime,phone) value (#{username},#{mailbox},#{altertime},#{phone})")
    void addMailbox(Mailbox mailbox);

    @Update("update mailbox set mailbox=#{mailbox} where username=#{username}")
    void altertimeMailbox(Mailbox mailbox);



}
