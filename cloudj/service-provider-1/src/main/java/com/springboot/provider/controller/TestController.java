package com.springboot.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provider")
public class TestController {

        @RequestMapping(value = "/hello")
        public String index(@RequestParam String name) {
            System.out.println("222222222222222222222222");
            return "hello "+name+"，this is first messge";
        }

}
