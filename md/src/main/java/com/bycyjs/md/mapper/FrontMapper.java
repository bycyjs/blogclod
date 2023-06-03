package com.bycyjs.md.mapper;

import com.bycyjs.md.pojo.Front;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface FrontMapper {
    /*分页查询*/
    @Select("select  * from front limit #{page},#{size}")
    List<Front> findByFrontPager(Map<String, Object> map);

    /*查询表的记录条数*/
    @Select("select count(1) from front")
    long findUFront();

    @Insert("insert into front (time,filename) " +
            "value (#{time},#{filename})")
    void addFront(Front front);

    @Select("select * from front where id=#{id}")
    Front selectFront(Front front);

}
