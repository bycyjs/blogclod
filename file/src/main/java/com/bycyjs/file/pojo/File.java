package com.bycyjs.file.pojo;

import lombok.Data;

@Data
public class File {
    private String username;
    private String uploadtime;
    private String filename;
    private float filesize;
    private String filetype;

}