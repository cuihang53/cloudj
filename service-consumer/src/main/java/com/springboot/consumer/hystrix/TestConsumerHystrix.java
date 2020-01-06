package com.springboot.consumer.hystrix;

import com.springboot.consumer.remote.TestConsumerRemote;
import org.springframework.stereotype.Component;

/****
 儅TestConsumerRemote類,調用遠程消息提供者spring-cloud-producer -> hello方法失敗時, 調用服務降級方法fallback=TestConsumerHystrix
 */
@Component
public class TestConsumerHystrix implements TestConsumerRemote {
    @Override
    public String hello(String name) {
        return "以及執行降級操作" + name;
    }
}
