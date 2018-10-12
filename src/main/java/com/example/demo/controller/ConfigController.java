package com.example.demo.controller;

import com.example.demo.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/6/28 2:11
 */
@RestController
public class ConfigController {
    @Autowired
    private ConfigBean configBean;

    @Value("${config.userName}")
    private String userName;

    @Value("${config.passWord}")
    private String passWord;

    @GetMapping("/config1")
    public String config1() {
        return configBean.getUserName() + ":" + configBean.getPassWord();
    }

    @GetMapping("/config2")
    public String config2() {
        return userName + ":" + passWord;
    }
}
