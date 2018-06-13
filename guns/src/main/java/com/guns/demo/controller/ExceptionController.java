package com.guns.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * 异常处理类
 */
@ControllerAdvice
public class ExceptionController {




    @ExceptionHandler()
    public String ex(Exception ex){
       if(ex instanceof RuntimeException){
            return "error";
       }
        return null;
    }
}
