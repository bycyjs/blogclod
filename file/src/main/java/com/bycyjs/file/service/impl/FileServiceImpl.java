package com.bycyjs.file.service.impl;

import com.bycyjs.file.mapper.FileMapper;
import com.bycyjs.file.pojo.File;
import com.bycyjs.file.pojo.User;
import com.bycyjs.file.service.FileService;
import com.bycyjs.file.tool.HttpEntityTool;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FileMapper fileMapper;
    private HttpEntityTool httpEntityTool=new HttpEntityTool();

    @Override
    public String upload(HttpServletRequest request, MultipartFile file) throws Exception {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(user);
        HttpEntity httpEntity1 = httpEntityTool.objPost(user);
        System.out.println(httpEntity1);
        String url = "http://login/login/validateUser";
       /* String url="http://localhost:8090/login/validateUser";*/
        String s = restTemplate.postForObject(url, httpEntity1, String.class);
        if ("succeed".equals(s)) {
            File file1 = new File();
            file1.setUsername(username);
            file1.setUploadtime(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
            if (file == null) {
                return "0";
            }

            file1.setFilename(file.getOriginalFilename());
            file1.setFiletype(file.getContentType());
            file1.setFilesize(file.getSize());
            /*获取文件是输入流*/
            InputStream inputStream = file.getInputStream();
            java.io.File file2 = new java.io.File("F:\\blog\\nginx-1.23.3\\html\\file\\upload\\" + username + "\\" + file1.getUploadtime());

            /*判断目录是否存在*/
            if (!file2.exists()) {
                file2.mkdirs();
            }

            OutputStream outputStream = new FileOutputStream("F:\\blog\\nginx-1.23.3\\html\\file\\upload\\" + username + "\\" + file1.getUploadtime() + "\\" + file.getOriginalFilename());
            /*执行文件拷贝*/
            IOUtils.copy(inputStream, outputStream);

            if (fileMapper.selectTable(file1) == null) {
                fileMapper.createTable(file1);
            }
            fileMapper.addRecord(file1);

            inputStream.close();
            outputStream.close();


            return "succeed";
        } else {
            return "1";
        }


    }
}
