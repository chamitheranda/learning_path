package com.chamith.jpa.unitintergrationtests.resource;

import com.chamith.jpa.unitintergrationtests.model.Users;
import com.chamith.jpa.unitintergrationtests.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class Resource {

    @Autowired
    private UserRepo userRepo ;

    @GetMapping("/")
    public List<Users> all(){
        return userRepo.findAll();
    }
}
