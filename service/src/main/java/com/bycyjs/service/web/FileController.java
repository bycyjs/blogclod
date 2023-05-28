package com.bycyjs.service.web;

import com.bycyjs.service.service.FileService;
import com.bycyjs.service.tool.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;

@RestController
@RequestMapping("/fileservice")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public R upload(HttpServletRequest request, @RequestBody MultipartFile file) throws IOException {

        return  fileService.upload(request,file );
    }

}
