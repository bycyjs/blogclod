package com.bycyjs.file.mapper;

import com.bycyjs.file.pojo.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper {

    @Select("show tables like #{username}")
    String selectTable(File file);

    void createTable(File file);


}
