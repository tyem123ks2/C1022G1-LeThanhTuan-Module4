package com.example.football_management.controller;

import com.example.football_management.exception.ExceptionHandle;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandleController {
    @ExceptionHandler(ExceptionHandle.class)
    public String showException() {
        return "/player/error";
    }
}
