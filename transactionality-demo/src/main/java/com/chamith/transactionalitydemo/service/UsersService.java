package com.chamith.transactionalitydemo.service;

import com.chamith.transactionalitydemo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private JdbcTemplate jdbcTemplate ;

    public void insert(List<Users> users){

        for (Users user : users) {
            System.out.println("Inserting Data for User name: " + user.getName());
            jdbcTemplate.update("insert into user(name, department, salary) values (?, ?, ?)",
                    preparedStatement -> {
                        preparedStatement.setString(1, user.getName());
                        preparedStatement.setString(2, user.getDepartment());
                        preparedStatement.setLong(3, user.getSalary());
                    });
        }

    }

    public List<Users> getUsers(){
        System.out.println("Retrieve all Users List...");
        List<Users> userList = jdbcTemplate.query("select name, department, salary from user", (resultSet, i) -> new Users(resultSet.getString("name"),
                resultSet.getString("department"),
                resultSet.getLong("salary")));

        return userList;
    }
}
