package com.bycyjs.service.service;

import com.bycyjs.service.tool.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;

@Service
public interface FileService {
    R upload(HttpServletRequest httpRequest, MultipartFile file) throws IOException;
}
