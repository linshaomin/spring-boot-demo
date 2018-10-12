package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/6/28 1:20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String getUserName(@RequestParam(value = "userName") String userName,@RequestParam(value = "age", required = false,defaultValue = "123") Integer age) {
        return userName + ":" + age;
    }

    @GetMapping("/{id}")
    public String getId(@PathVariable("id") Integer id){
        return "id:"+id;
    }
}
