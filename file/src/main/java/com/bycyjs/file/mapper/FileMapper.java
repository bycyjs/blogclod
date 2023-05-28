package com.bycyjs.file.mapper;

import com.bycyjs.file.pojo.File;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("show tables like #{username}")
    String selectTable(File file);

    void createTable(File file);

    @Insert("insert into ${username} (filename,uploadtime,filesize,filetype) " +
            "value(#{filename},#{uploadtime},#{filesize},#{filetype})")
    void addRecord(File file);

    @Select("select * from ${username}")
    List<File> selectRecord(File file);

    @Delete("delete from ${username} where filename=#{filename} and uploadtime=#{uploadtime}")
    void deleteRecord(File file);


}
