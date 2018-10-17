package com.example.demo.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/17 16:28
 */
@RestController
public class AopTestController {
    @GetMapping(value = "/aoptest")
    public String aopTest(){
        return " AOP test success!";
    }
}
