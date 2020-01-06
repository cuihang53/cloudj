package com.springboot.consumer.controller;


import com.springboot.consumer.hystrix.TestConsumerHystrix;
import com.springboot.consumer.remote.TestConsumerRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/consumer")
@RestController
public class TestConsumerController {

    @Autowired
    TestConsumerRemote testService;


    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        System.out.println(name);
        return testService.hello(name);
    }

}
