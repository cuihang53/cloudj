package com.ribbon.controller;

import com.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


        @Autowired
        HelloService service;

        @RequestMapping("/hi/{time}")
        public String customer(@PathVariable("time") Long time){
            return service.helloService(time);
        }
    }