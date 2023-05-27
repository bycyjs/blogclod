package com.bycyjs.file.service.impl;

import com.bycyjs.file.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements FileService {
    @Override
    public String upload(HttpServletRequest request, MultipartFile file) {
        return null;
    }
}
