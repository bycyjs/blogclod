package com.bycyjs.file.controller;

import com.bycyjs.file.pojo.File;
import com.bycyjs.file.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController{

    @Autowired
    private FileService fileService;


    @PostMapping("/upload")
    public String upload(HttpServletRequest request, @RequestBody MultipartFile file) throws Exception {

        return fileService.upload(request,file);
    }
    @PostMapping("/selectRecord")
    public List<File> selectRecord(HttpServletRequest request) throws Exception {
        return fileService.selectRecord(request);
    }
    @GetMapping("/deleteRecord/{id}")
    public String deleteRecord(HttpServletRequest request,@PathVariable("id") Integer id) throws Exception {
        return fileService.deleteRecord(request,id);
    }
}
