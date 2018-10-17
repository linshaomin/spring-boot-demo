package com.example.demo.exception.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    USER_NOT_FIND(-101,"用户不存在");

    private Integer code;

    private String msg;

}
