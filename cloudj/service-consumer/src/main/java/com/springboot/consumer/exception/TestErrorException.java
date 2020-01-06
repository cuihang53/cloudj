package com.springboot.consumer.exception;

public class TestErrorException extends Exception {
    public TestErrorException(String error){
        super(error);
    }
}
