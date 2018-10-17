package com.example.demo.exception.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shaomin.lin
 * @Description:返回体报文
 * @date 2018/10/17 17:09
 */
@Setter
@Getter
public class Result<T> {

    // error_code 状态值：0 极为成功，其他数值代表失败
    private Integer status;

    //error_msg 错误信息，若status为0时，为success
    private String msg;

    //content 返回体报文的出参，使用泛型兼容不同的类型
    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
