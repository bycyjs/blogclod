package com.bycyjs.service.bojo;

import lombok.Data;

@Data
public class File {
    private Integer id;
    private String username;
    private String uploadtime;
    private String filename;
    private float filesize;
    private String filetype;

}
