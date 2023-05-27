package com.bycyjs.service.service.impl;

import com.bycyjs.service.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();

    @Override
    public void upload(HttpServletRequest request, MultipartFile file) {
       httpHeaders.add("Content-Type",request.getHeader("Content-Type"));

        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        httpHeaders.add("username",request.getHeader("username"));
        httpHeaders.add("password",request.getHeader("password"));
        System.out.println(httpHeaders);

        HttpEntity httpEntity=new HttpEntity(file,httpHeaders);

        String url="http://file/file/upload";
        String s = restTemplate.postForObject(url, httpEntity, String.class);



    }
}
