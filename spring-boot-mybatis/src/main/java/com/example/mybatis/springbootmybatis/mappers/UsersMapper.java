package com.example.mybatis.springbootmybatis.mappers;

import com.example.mybatis.springbootmybatis.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from users")
    List<Users> findAll();


    @Insert("insert into users(name,salary,id) values(#{name},#{salary},#{id})")
    void insert(Users users);

}
