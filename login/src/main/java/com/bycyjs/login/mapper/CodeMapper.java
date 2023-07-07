package com.bycyjs.login.mapper;

import com.bycyjs.login.pojo.ValidateCode;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CodeMapper {
    @Insert("insert into validatecode (mailbox,time,code) value (#{mailbox},#{time},#{code})")
    void insertValidateCode(ValidateCode code);

    @Select("select * from validatecode where mailbox=#{mailbox}")
    ValidateCode selectMailbox(ValidateCode mailbox);

    @Update("update validatecode set time=#{time},code=#{code} where mailbox=#{mailbox}")
    void updateMailbox(ValidateCode mailbox);

}
