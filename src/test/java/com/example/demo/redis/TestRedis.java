package com.example.demo.redis;

import com.alibaba.fastjson.parser.ParserConfig;
import com.example.demo.mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void setString(){
        stringRedisTemplate.opsForValue().set("test2","testValue1");
    }

    @Test
    public void setUser(){
        User user = new User(123,"kkk","1234","666");
        redisTemplate.opsForValue().set("user",user);
    }

    @Test
    public void getString(){
        System.out.println(stringRedisTemplate.opsForValue().get("mystring"));
    }

    @Test
    public void getUser(){
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        User user = (User)redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }
}