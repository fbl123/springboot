package com.huijie.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

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
