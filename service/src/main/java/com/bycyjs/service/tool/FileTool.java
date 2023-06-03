package com.bycyjs.service.tool;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class FileTool {


    public void nonce(MultipartFile file, String username) throws IOException {
        /*获取文件是输入流*/
        InputStream inputStream = file.getInputStream();
        java.io.File file2 = new java.io.File("F:\\blog\\html\\file\\upload\\nonce\\" + username);
        /*判断目录是否存在*/
        if (!file2.exists()) {
            boolean mkdirs = file2.mkdirs();
        }
        OutputStream outputStream = new FileOutputStream("F:\\blog\\html\\file\\upload\\nonce\\" + username + "\\" + file.getOriginalFilename());
        /*执行文件拷贝*/
        IOUtils.copy(inputStream, outputStream);
        inputStream.close();
        outputStream.close();
    }

    //读取本地文件上传
    @Autowired
    RestTemplate restTemplate;

    public String remotRequest(HttpServletRequest request, String filename) {

        String url = "http://file/file/upload";
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();

        //读取本地文件  "D:/upload/file";
        String filePath = "F:\\blog\\html\\file\\upload\\nonce\\" + request.getHeader("username") + "\\" + filename;
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);

        System.out.println(filePath);

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        params.add("file", fileSystemResource);
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        headers.add("password", request.getHeader("password"));
        headers.add("username", request.getHeader("username"));
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        String result = restTemplate.postForObject(url, requestEntity, String.class);
        return result;
    }


}