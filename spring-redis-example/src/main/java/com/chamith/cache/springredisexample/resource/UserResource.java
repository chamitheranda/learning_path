package com.chamith.cache.springredisexample.resource;

import com.chamith.cache.springredisexample.model.User;
import com.chamith.cache.springredisexample.repo.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    private UserRepo userRepo ;

    public UserResource(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id ,
                    @PathVariable("name") final String name){
        userRepo.save(new User(id , name , 20000L));
        return userRepo.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id ,
                    @PathVariable("name") final String name){
        userRepo.update(new User(id , name , 10000L));
        return userRepo.findById(id);
    }

    @GetMapping("/all")
    public Map<String , User> getAll(){
        return userRepo.findAll();
    }

    @GetMapping("/delete/{id}")
    public Map<String , User> delete(@PathVariable("id") final String id){
        userRepo.delete(id);
        return getAll();
    }
}
