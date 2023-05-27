package com.bycyjs.file.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
    String upload(HttpServletRequest request, MultipartFile file);
}
