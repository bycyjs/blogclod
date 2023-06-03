package com.bycyjs.md.service.impl;

import com.bycyjs.md.mapper.FrontMapper;
import com.bycyjs.md.model.Pager;
import com.bycyjs.md.pojo.Front;
import com.bycyjs.md.service.MdService;
import com.bycyjs.md.tool.R;
import com.bycyjs.md.util.MdUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MdServiceImpl implements MdService {

    @Autowired
    private FrontMapper frontMapper;
    @Autowired
    private RestTemplate restTemplate;

    /*分页查询*/
    @Override
    public R findByFrontPager(Integer page, Integer size) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", (page - 1) * size);
        params.put("size", size);
        List<Front> list = frontMapper.findByFrontPager(params);
        Pager<Front> pager = new Pager<Front>();
        pager.setData(list);
        pager.setTotal(frontMapper.findUFront());
        return R.success(pager);

    }

    @Override
    public R addFront(HttpServletRequest request, MultipartFile file) throws IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String originalFilename = file.getOriginalFilename();
        String time = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        Front front = new Front();
        front.setFilename(originalFilename);
        front.setTime(time);
        Front front1 = frontMapper.selectFront(front);
        /*判断以前是上传过该文件名的文件*/
        /*if(front1!=null){

        }*/


        InputStream inputStream = file.getInputStream();
        File file1 = new File("F:\\blog\\html\\md\\learnnote\\Front\\" + time);

        if (!file1.exists()) {
            file1.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\blog\\html\\md\\learnnote\\Front\\" + time + "\\" + originalFilename);
        /*执行文件拷贝*/
        IOUtils.copy(inputStream, fileOutputStream);

        frontMapper.addFront(front);


        return R.success("success");
    }

    @Override
    public R selectFront(String time, String filename) throws IOException {
        time = time.substring(0, 10);
        String flie = "F:\\blog\\html\\md\\learnnote\\Front\\" + time + "\\" + filename;
        String fileContent;
        try {
            List<String> lines = Files.readAllLines(Paths.get(flie));
            fileContent = String.join(System.lineSeparator(), lines);
            /*System.out.println(fileContent);*/
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            return R.error("" + e);
        }


        return null;


    }


}
