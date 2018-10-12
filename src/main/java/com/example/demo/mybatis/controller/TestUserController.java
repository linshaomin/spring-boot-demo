package com.example.demo.mybatis.controller;

import com.example.demo.mybatis.model.User;
import com.example.demo.mybatis.service.TestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/11 17:57
 */
@Api(value = "TestUserController", description = "用户接口")
@RestController
@RequestMapping("/testUser")
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    @ApiOperation(value="根据手机查询用户信息")
    @GetMapping
    public User findUserByPhone(@ApiParam(value = "手机号", required = true) @RequestParam(value = "phone") String phone) {
        return testUserService.findUserByPhone(phone);
    }
}
