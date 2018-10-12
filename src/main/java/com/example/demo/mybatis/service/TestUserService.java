package com.example.demo.mybatis.service;

import com.example.demo.mybatis.mapper.TestUserMapper;
import com.example.demo.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/12 11:20
 */
@Service
@Transactional
public class TestUserService {

    @Autowired
    private TestUserMapper testUserMapper;

    public User findUserByPhone(String phone) {
        return testUserMapper.findUserByPhone(phone);
    }

}
