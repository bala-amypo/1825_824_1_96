package com.exmaple.demo.exception;

import java.lang;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}