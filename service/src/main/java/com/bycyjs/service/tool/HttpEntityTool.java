package com.bycyjs.service.tool;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
public class HttpEntityTool {

    private ObjectMapper objectMapper = new ObjectMapper();
    private HttpHeaders httpHeaders = new HttpHeaders();


    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }
    /*封装的一个工具类，可以封装HttpEntity类型
    * 里面默认封装了一个httpHeaders.add("Content-Type", "application/json");
    *
    * */

    public HttpEntity objPost(Object object) throws Exception {

        Map<String, Object> map = new HashMap<>();
        Field[] declaredFields = object.getClass().getDeclaredFields();

        for (Field f:declaredFields){
            f.setAccessible(true);
            String get="get"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1);
            Method method = object.getClass().getMethod(get, new Class[]{});
            Object invoke = method.invoke(object, new Object[]{});
            map.put(f.getName(),invoke);
        }
        String s = objectMapper.writeValueAsString(object);
        httpHeaders.add("Content-Type", "application/json");
        HttpEntity httpEntity = new HttpEntity<>(s, httpHeaders);
        return httpEntity;
    }
}
