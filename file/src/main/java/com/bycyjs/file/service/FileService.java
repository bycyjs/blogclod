package com.bycyjs.file.service;

import com.bycyjs.file.pojo.File;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface FileService {
    String upload(HttpServletRequest request, MultipartFile file) throws Exception;

    List<File> selectRecord(HttpServletRequest request) throws Exception;

    String deleteRecord(HttpServletRequest request,Integer id) throws Exception;
}
