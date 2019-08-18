package com.sky.error.controller;

import com.sky.error.exception.DemoException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @RequestMapping("/demo/{num}")
    public Object demo(@PathVariable("num") String num) throws DemoException {
        Integer opNum = null;
        try {
            opNum = Integer.valueOf(num);
            return 1 / opNum;
        } catch (Exception e) {
            throw new DemoException(e.getMessage());
        }
    }
}
