package com.example.demo.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author shaomin.lin
 * @Description: java8 stream api
 * @date 2018/9/9 11:15
 */

public class StreamTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("test1",10,10));
        list.add(new Student("test1",10,20));
        list.add(new Student("test2",20,30));
        list.add(new Student("test3",40,30));
        //根据name分组
        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
        for(String s : map.keySet()) {
            System.out.println("key:" + s + ",value:" + map.get(s).toString());
        }
    }
}
