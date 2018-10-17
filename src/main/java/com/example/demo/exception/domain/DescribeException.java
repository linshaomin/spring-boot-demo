package com.example.demo.exception.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/17 17:21
 */
@Setter
@Getter
public class DescribeException extends RuntimeException{

    private Integer code;

    /**
     * 继承exception，加入错误状态值
     * @param exceptionEnum
     */
    public DescribeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    public DescribeException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
