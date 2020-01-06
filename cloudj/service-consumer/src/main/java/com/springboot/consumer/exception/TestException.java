package com.springboot.consumer.exception;

public class TestException extends  Exception {

    public TestException() {
        // TODO Auto-generated constructor stub
        super();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return"程序发生了越界异常！ 请检查下标变化！";
    }

}
