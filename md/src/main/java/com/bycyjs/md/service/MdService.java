package com.bycyjs.md.service;

import com.bycyjs.md.pojo.Front;
import com.bycyjs.md.tool.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public interface MdService {
    R findByFrontPager(Integer page, Integer size);

    R addFront(HttpServletRequest request, MultipartFile file) throws IOException;

    R selectFront(String time,String filename) throws IOException;
}
