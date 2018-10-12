package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestUserMapper {

    @Select("select * from t_user where phone = #{phone}")
    User findUserByPhone(@Param("phone") String phone);

    @Insert("insert into t_user(name, password, phone) values(#{name}, #{password}, #{phone})")
    int insertByUser(User user);

    @Update("update t_user set name = #{name}, password = #{password} where phone = #{phone}")
    int update(User user);

    @Delete("delete from t_user where id = #{id}")
    int delete(Integer id);

}
