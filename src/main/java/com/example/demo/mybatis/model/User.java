package com.example.demo.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/11 14:33
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class User {

    private Integer id;

    private String name;

    private String password;

    private String phone;

}
