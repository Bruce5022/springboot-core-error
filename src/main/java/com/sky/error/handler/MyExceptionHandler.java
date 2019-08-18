package com.sky.error.handler;

import com.sky.error.exception.DemoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(DemoException.class)
//    public Object handleException(Exception e) {
//        Map<String,Object> map = new HashMap<>();
//        map.put("status",-1);
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(DemoException.class)
    public Object handleException(Exception e, HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code",400);
        Map<String,Object> map = new HashMap<>();
        map.put("status",-1);
        map.put("message",e.getMessage());
        request.setAttribute("err",map);
        return "forward:/error";
    }
}
