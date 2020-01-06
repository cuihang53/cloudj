package com.springboot.consumer.remote;

import com.springboot.consumer.hystrix.TestConsumerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//服務生產者名稱  也就是service-producer  application.properties的spring.application.name
//fallback 是hystrix的降級操作
@FeignClient(name= "spring-cloud-producer", fallback= TestConsumerHystrix.class)
public interface TestConsumerRemote {
    @RequestMapping(value = "/api/provider/hello")
    public String hello(@RequestParam(value = "name") String name);
}