package com.ribbon.controller;


import com.ribbon.service.TestRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/ribbon")
@RestController
public class TestRibbonController {


    protected HttpServletRequest request;
    protected HttpServletResponse response;
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Autowired
    TestRibbonService testRibbonService;

    @RequestMapping("/hello")
    public String testA() throws InterruptedException {
        Long time = Long.parseLong(request.getParameter("time"));
        System.out.print("即將 休眠[" + time + "]ms");
        Thread.sleep(time);
        System.out.print("休眠 結束[" + time + "]ms");
//        while(true){

//        }
    testRibbonService.test();
//        System.out.println(name);
        return "Hello world AAAAAAAAAA!";
    }
}
