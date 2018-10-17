package com.example.demo.exception.controller;

import com.example.demo.exception.domain.ExceptionEnum;
import com.example.demo.exception.domain.Result;
import com.example.demo.exception.handler.ExceptionHandle;
import com.example.demo.exception.util.ResultUtil;
import com.example.demo.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/17 17:33
 */
@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ExceptionHandle exceptionHandle;

    /**
     * 返回体测试
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/getResult",method = RequestMethod.POST)
    public Result getResult(@RequestParam("name") String name, @RequestParam("pwd") String pwd){
        Result result = ResultUtil.success();
        try {
            if (name.equals("test1")){
                result =  ResultUtil.success(new User(1,name,pwd,"123"));
            }else if (name.equals("test2")){
                result =  ResultUtil.error(ExceptionEnum.USER_NOT_FIND);
            }else{
                int i = 1/0;
            }
        }catch (Exception e){
            result =  exceptionHandle.exceptionGet(e);
        }
        return result;
    }
}
