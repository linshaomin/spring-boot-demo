package com.example.demo.mybatis.model;

import lombok.*;

import java.io.Serializable;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/11 14:33
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;

    private String name;

    private String password;

    private String phone;

}
