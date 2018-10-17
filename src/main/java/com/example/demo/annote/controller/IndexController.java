package com.example.demo.annote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/6/28 0:53
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
