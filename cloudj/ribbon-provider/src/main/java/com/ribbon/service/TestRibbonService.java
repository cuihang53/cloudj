package com.ribbon.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestRibbonService {


    @Autowired
    RestTemplate restTemplate;

    public String test(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("mame","test");
        ResponseEntity<String> obj =  restTemplate.getForEntity("http://spring-cloud-consumer/api/consumer/hello/{name}",String.class, "test");




//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayhello?name={1}", String.class, "张三");
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayhello?name={name}", String.class, map);
        System.out.println(obj);
        return  obj==null ? "timeout" : obj.getBody().toString();
    }

}
