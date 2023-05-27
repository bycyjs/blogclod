package com.bycyjs.service.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.http.HttpRequest;

@Service
public interface FileService {
    void upload(HttpServletRequest httpRequest,  MultipartFile file);
}
