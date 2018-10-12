package com.example.demo.mybatis;


import com.example.demo.mybatis.mapper.TestUserMapper;
import com.example.demo.mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/11 14:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private TestUserMapper testUserMapper;

    @Test
//    @Transactional
    public void test(){
        User u = new User(null,"张三", "123456", "18600000000");
        System.out.println(testUserMapper.insertByUser(u));
    }
}
