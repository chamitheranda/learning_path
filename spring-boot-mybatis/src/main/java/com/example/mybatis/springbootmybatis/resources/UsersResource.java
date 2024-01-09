package com.example.mybatis.springbootmybatis.resources;

import com.example.mybatis.springbootmybatis.mappers.UsersMapper;
import com.example.mybatis.springbootmybatis.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {


    private UsersMapper usersMapper ;

    public UsersResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @GetMapping("/all")
    public List<Users> getAll(){
        return usersMapper.findAll();
    }

    @GetMapping("/update")
    private List<Users> update(){

        Users users = new Users();
        users.setName("supun");
        users.setSalary(22000);
        users.setId(3);

        usersMapper.insert(users);
        return usersMapper.findAll();
    }
}
