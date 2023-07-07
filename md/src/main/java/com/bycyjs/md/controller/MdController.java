package com.bycyjs.md.controller;

import com.bycyjs.md.service.MdService;
import com.bycyjs.utils.common.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/md")
public class MdController {

    @Autowired
    private MdService mdService;

    @GetMapping("/findByFrontPager/{page}/{size}")
    public R findByFrontPager(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return mdService.findByFrontPager(page,size);
    }


    @PostMapping("/addFront")
    public R addFront(HttpServletRequest request, MultipartFile file) throws IOException{
        return mdService.addFront(request,file);
    }
    @GetMapping("/selectFront/{time}/{filename}")
    public R selectFront(@PathVariable("time") String time,@PathVariable("filename") String filename) throws IOException {
        return mdService.selectFront(time,filename);
    }

}
