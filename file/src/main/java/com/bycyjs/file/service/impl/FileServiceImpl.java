package com.bycyjs.file.service.impl;

import com.bycyjs.file.mapper.FileMapper;
import com.bycyjs.file.pojo.File;
import com.bycyjs.file.pojo.User;
import com.bycyjs.file.service.FileService;
import com.bycyjs.utils.common.HttpEntityTool;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FileMapper fileMapper;
    private HttpEntityTool httpEntityTool = new HttpEntityTool();

    /*上传文件*/
    @Override
    public String upload(HttpServletRequest request, MultipartFile file) throws Exception {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        User user = new User();
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
            java.io.File file2 = new java.io.File("E:\\file\\upload\\" + username + "\\" + file1.getUploadtime());

            /*判断目录是否存在*/
            if (!file2.exists()) {
                file2.mkdirs();
            }

            OutputStream outputStream = new FileOutputStream("E:\\file\\upload\\" + username + "\\" + file1.getUploadtime() + "\\" + file.getOriginalFilename());
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

    /*查找文件*/
    @Override
    public List<File> selectRecord(HttpServletRequest request) throws Exception {


        String username = request.getHeader("username");
        String password = request.getHeader("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpEntity httpEntity1 = httpEntityTool.objPost(user);

        String url = "http://login/login/validateUser";
        File file = new File();
        file.setUsername(username);
        /* System.out.println(httpEntity1.getHeaders());*/

        String s = restTemplate.postForObject(url, httpEntity1, String.class);

        if ("succeed".equals(s)) {
            return fileMapper.selectRecord(file);
        } else {
            return null;
        }

    }

    /*删除文件*/
    @Override
    public String deleteRecord(HttpServletRequest request,Integer id) throws Exception {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpEntity httpEntity1 = httpEntityTool.objPost(user);

        String url = "http://login/login/validateUser";
        File file = new File();
        file.setUsername(username);
        file.setId(id);

        /* System.out.println(httpEntity1.getHeaders());*/

        String s = restTemplate.postForObject(url, httpEntity1, String.class);

        if ("succeed".equals(s)) {
            File file1 = fileMapper.selectId(file);
            String path="E:\\file\\upload\\" + username + "\\" + file1.getUploadtime() + "\\" + file1.getFilename();
            java.io.File file2=new java.io.File(path);
            if(file2.exists()){
                file2.delete();
            }
            fileMapper.deleteRecord(file);
        }

        return "succeed";
    }

    @Override
    public String download(Integer id,
                                       HttpServletRequest request, HttpServletResponse response
                                       ) throws Exception {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpEntity httpEntity1 = httpEntityTool.objPost(user);

        String url = "http://login/login/validateUser";
        File file = new File();
        file.setUsername(username);
        file.setId(id);


        /* System.out.println(httpEntity1.getHeaders());*/

        String s = restTemplate.postForObject(url, httpEntity1, String.class);

        if ("succeed".equals(s)) {
          /*  File file1 = fileMapper.selectId(file);
            String path="E:\\file\\upload\\"+username+"\\"+file1.getUploadtime()+"\\"+file1.getFilename();
            try {
                // path是指欲下载的文件的路径。
                java.io.File file2 = new java.io.File(path);
                // 取得文件名。
                String filename = file2.getName();
                // 取得文件的后缀名。
                String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
                // 以流的形式下载文件。
                InputStream fis = new BufferedInputStream(new FileInputStream(path));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
                response.addHeader("Content-Length", "" + file2.length());
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                toClient.write(buffer);
                toClient.flush();
                toClient.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }*/
            return "succeed";

        }
        return "fail";

    }
}
