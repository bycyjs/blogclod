package com.bycyjs.service.web;

import com.bycyjs.service.tool.FileTool;
import com.bycyjs.service.tool.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Slf4j
@RestController
@RequestMapping("/mdservice")
public class MdController {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/findByFrontPager/{page}/{size}")
    public R findByFrontPager(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        String url="http://md/md/findByFrontPager/"+page+"/"+size;
        return restTemplate.getForObject(url,R.class);
    }


    @PostMapping("/addFront")
    public R addFront(HttpServletRequest request, MultipartFile file) throws IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        FileTool fileTool = new FileTool();
        /*将文件临时存储的方法*/
        fileTool.nonce(file, username);
        /*获取位置所在的位置*/
        String filePath = "F:\\blog\\html\\file\\upload\\nonce\\" + request.getHeader("username") + "\\" + file.getOriginalFilename();
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        /*访问文件服务器*/
        String url = "http://md/md/addFront";
        HttpHeaders headers = new HttpHeaders();
        params.add("file", fileSystemResource);
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        headers.add("password", request.getHeader("password"));
        headers.add("username", request.getHeader("username"));
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        String result = restTemplate.postForObject(url, requestEntity, String.class);

        /*删除临时文件夹*/
        String path="F:\\blog\\html\\file\\upload\\nonce\\" + request.getHeader("username");
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


    @GetMapping("/selectFront/{time}/{filename}")
    public R selectFront(@PathVariable("time") String time,@PathVariable("filename") String filename){
        String url="http://md/md/selectFront/"+time+"/"+filename;

        return  restTemplate.getForObject(url,R.class);
    }
}
