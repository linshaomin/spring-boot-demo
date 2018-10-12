package com.example.demo.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/9/9 11:17
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Student {
    private String name;
    private int score;
    private int age;
}
