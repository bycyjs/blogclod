package com.bycyjs.file.controller;

import com.bycyjs.file.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController{

    @Autowired
    private FileService fileService;


    @PostMapping("/upload")
    public String upload(HttpServletRequest request, @RequestBody MultipartFile file) throws Exception {

        return fileService.upload(request,file);
    }
}
