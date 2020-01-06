package com.springboot.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中
@RequestMapping("/api/config")
public class TestClientController {

    @Value("${world}")
    private String word;

    @RequestMapping("/hello")
//    @HystrixCommand(fallbackMethod="helloFallBack")
    public String index(@RequestParam String name) {
        return name+","+this.word;
    }





//    public String helloFallBack(){
//        return "Error occurred!";
//    }

}
