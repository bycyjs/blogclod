package com.bycyjs.service.web;

import com.bycyjs.service.bojo.File;
import com.bycyjs.service.service.FileService;
import com.bycyjs.utils.common.R;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/fileservice")
public class FileController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public R upload(HttpServletRequest request, @RequestBody MultipartFile file) throws IOException {

        return fileService.upload(request, file);
    }

    @PostMapping("/selectRecord")
    public R selectRecord(HttpServletRequest request) {
        return fileService.selectRecord(request);

    }

    @GetMapping("/deleteRecord/{id}")
    public R deleteRecord(HttpServletRequest request, @PathVariable Integer id) throws Exception {


        return fileService.deleteRecord(request, id);
    }
    /*文件下载*/

    @PostMapping("/download")
    public HttpServletResponse download(@RequestBody File file, HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.add("username", request.getHeader("username"));
        headers.add("password", request.getHeader("password"));
        String url = "http://file/file/download/" + file.getId();
        HttpEntity http = new HttpEntity(headers);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, http, String.class);
        String body = exchange.getBody();
//        response = (HttpServletResponse) exchange1.getBody() ;
//        System.out.println(exchange.getBody());
//        System.out.println(exchange);
//        response= (HttpServletResponse) exchange;
        System.out.println(body);
        String path="E:\\file\\upload\\"+request.getHeader("username")+"\\"+file.getUploadtime()+"\\"+file.getFilename();
        if ("succeed".equals(body)){
            // 获得待下载文件所在文件夹的绝对路径
            String realPath =path;
            // 获得文件输入流
            FileInputStream inputStream = new FileInputStream(new java.io.File(realPath));
            // 设置响应头、以附件形式打开文件
            response.setContentLength((int) new java.io.File(realPath).length());
            response.setHeader("content-disposition", "attachment; filename=" +file.getFilename());
            ServletOutputStream outputStream = response.getOutputStream();

            int len = 0;
            byte[] data = new byte[1024];
            while ((len = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, len);
            }
            outputStream.close();
            inputStream.close();

            return null;
        }
        return null;

    }

}
