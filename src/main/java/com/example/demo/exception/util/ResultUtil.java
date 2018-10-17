package com.example.demo.exception.util;

import com.example.demo.exception.domain.ExceptionEnum;
import com.example.demo.exception.domain.Result;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/17 17:17
 */
public class ResultUtil {

    /**
     * 返回成功，传入返回体具体出參
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setStatus(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setStatus(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param exceptionEnum
     * @return
     */
    public static Result error(ExceptionEnum exceptionEnum){
        Result result = new Result();
        result.setStatus(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }
}
