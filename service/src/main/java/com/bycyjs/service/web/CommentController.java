package com.bycyjs.service.web;

import com.bycyjs.service.bojo.Comment;
import com.bycyjs.utils.common.HttpEntityTool;
import com.bycyjs.utils.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/commentservice")
@Slf4j
public class CommentController {

    @Autowired
    private RestTemplate restTemplate;

    /*加载评论*/
    @GetMapping("findByCommentPager/{page}/{size}")
    public R findByCommentPager(@PathVariable("page") int page, @PathVariable("size") int size) {

        String url = "http://comment/comment/findByCommentPager/" + page + "/" + size;
        R forObject = null;
        try {
            forObject = restTemplate.getForObject(url, R.class);
        } catch (Exception e) {
            log.error("" + e);
            return R.success("" + e);
        }

        return forObject;
    }

    /*添加评论*/
    @PostMapping("/addComment")
    public R addComment(@RequestBody Comment comment) throws Exception {

        String url = "http://comment/comment/addComment";
        HttpEntityTool httpEntityTool = new HttpEntityTool();
        HttpEntity http = httpEntityTool.objPost(comment);
        R r = null;
        try {
            r = restTemplate.postForObject(url, http, R.class);
        } catch (Exception e) {
            log.error("" + e);
            return R.error("" + e);
        }
        return r;
    }


    @GetMapping("/setPraise/{id}")
    public R setPraise(@PathVariable("id") Integer id){
       String url="http://comment/comment/setPraise/"+id;
        return restTemplate.getForObject(url, R.class);
    }

    @GetMapping("/setTread/{id}")
    public R setTread(@PathVariable("id") Integer id){
        String url ="http://comment/comment/setTread/"+id;

        return restTemplate.getForObject(url,R.class);
    }


}
