package com.chamith.transactionalitydemo.runner;

import com.chamith.transactionalitydemo.model.Users;
import com.chamith.transactionalitydemo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired
    private UsersService usersService ;

//    @Transactional
    @Override
    public void run(String... args)  {
        try {
            Users user1 = new Users("kasun","tech",10000);
            Users user2 = new Users("supun","data",21000);
            usersService.insert(Arrays.asList(
                    user1,user2
            ));
        }catch (RuntimeException exception){
            System.out.println("Exception in batch 1  ...." + exception.getMessage());
            System.out.println(usersService.getUsers());
        }
        try {
            Users user3 = new Users("rrr","fashion",18000);
            Users user4 = new Users("piyumal","cloth",7500);
            usersService.insert(Arrays.asList(
                   user3,user4
            ));
        }catch (RuntimeException exception){
            System.out.println("Exception in badge 2 ...." + exception.getMessage());
        }
        System.out.println(usersService.getUsers());

    }

}
