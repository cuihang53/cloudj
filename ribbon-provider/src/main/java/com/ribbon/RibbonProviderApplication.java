package com.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

@EnableDiscoveryClient
public class RibbonProviderApplication {

    @Bean                     // 注册一个具有容错功能的RestTemplate
    @LoadBalanced
        // 开启负载均衡客户端
    RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setReadTimeout(600000); //超時10分鐘
        factory.setReadTimeout(60000); //6m
        factory.setConnectTimeout(2000);
        return new RestTemplate(factory);
    }
    public static void main(String[] args) {

        SpringApplication.run(RibbonProviderApplication.class, args);
    }

}
