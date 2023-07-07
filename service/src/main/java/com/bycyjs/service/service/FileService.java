package com.bycyjs.service.service;

import com.bycyjs.utils.common.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileService {
    R upload(HttpServletRequest httpRequest, MultipartFile file) throws IOException;
    R selectRecord (HttpServletRequest request);
     R deleteRecord(HttpServletRequest request,Integer id);
}
