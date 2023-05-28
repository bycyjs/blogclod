package com.bycyjs.service.service.impl;

import com.bycyjs.service.service.FileService;
import com.bycyjs.service.tool.FileTool;
import com.bycyjs.service.tool.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
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

import java.io.File;
import java.io.IOException;


@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Autowired
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();

    @Override

    public R upload(HttpServletRequest request, MultipartFile file) throws IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        FileTool fileTool = new FileTool();
        /*将文件临时存储的方法*/
        fileTool.nonce(file, username);
        /*获取位置所在的位置*/
        String filePath = "F:\\blog\\nginx-1.23.3\\html\\file\\upload\\nonce\\" + request.getHeader("username") + "\\" + file.getOriginalFilename();
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        /*访问文件服务器*/
        String url = "http://file/file/upload";
        HttpHeaders headers = new HttpHeaders();
        params.add("file", fileSystemResource);
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        headers.add("password", request.getHeader("password"));
        headers.add("username", request.getHeader("username"));
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        String result = restTemplate.postForObject(url, requestEntity, String.class);

        /*删除临时文件夹*/
        String path="F:\\blog\\nginx-1.23.3\\html\\file\\upload\\nonce\\" + request.getHeader("username");
        File file1=new File(path);
        if(file1.exists()){
            boolean delete = file1.delete();
            if (delete){
                log.info("删除临时文件夹成功");
            }else {
                File[] files=file1.listFiles();
                for(File f:files){
                    boolean delete1 = f.delete();
                }
                file1.delete();
            }

        }


        return R.success(result);


    }
}
