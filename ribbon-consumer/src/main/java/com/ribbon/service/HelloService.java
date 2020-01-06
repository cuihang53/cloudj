package com.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService {


    @Autowired
    RestTemplate restTemplate;            // 负载均衡ribbon对象



    /**
     * 调用Eureka系统中名都为test-service的ribbon_service_a或ribbon_service_b的方法/hello
     * @return
     */
    // 注解指定发生错误时的回调方法
    @HystrixCommand(fallbackMethod="helloFallBack")
    public String helloService(Long time) {
        // Get请求调用服务，restTemplate被@LoadBalanced注解标记，Get方法会自动进行负载均衡
        // restTemplate会交替调用service_a和service_b
//        String obj=  restTemplate.getForObject("http://spring-cloud-ribbon-provider/api/ribbon/hello", String.class);
        long startTime=System.currentTimeMillis();

        Map<String,Long> map = new HashMap<String,Long>();
        map.put("time",time);
        ResponseEntity<String> obj=null;
        try{
            System.out.println("-----start time " + startTime);
            obj=    restTemplate.getForEntity("http://spring-cloud-ribbon-provider/api/ribbon/hello?time={time}",String.class, map);
        }catch (Exception e){
            long endTime=System.currentTimeMillis(); //获取结束时间
//            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
            e.printStackTrace();
            System.out.println("程序运行时间： "+(endTime-startTime)+"ms - "  + (endTime-startTime)/60000 +"m");
        }




//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayhello?name={1}", String.class, "张三");
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayhello?name={name}", String.class, map);
        System.out.println(obj);
        return  obj==null ? "timeout" : obj.getBody().toString();
    }

    //     熔断错误回调方法
    public String helloFallBack(Long time){
        return "Error occurred! ReadTimeout " + time ;
    }
}
