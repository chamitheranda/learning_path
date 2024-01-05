package com.example.hateoasexample.resource;

import com.example.hateoasexample.model.Users;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {
    @GetMapping("/all")
    public List<Users> getAll(){
        Users user1 = new Users("chamith eranda" , 23000L);
        Users user2 = new Users("kasun sampath" , 33000L);
        return Arrays.asList(user1,user2);
    }

    @GetMapping(value = "/hateoas/all" , produces = MediaTypes.HAL_JSON_VALUE)
    public List<EntityModel<Users>> getHateOASAll(){

        Users user1 = new Users("chamith" , 23000L);
        EntityModel<Users> user1Resource = EntityModel.of(user1);
        user1Resource.add(WebMvcLinkBuilder.linkTo(UsersResource.class).slash(user1.getName()).withSelfRel());
        Users user2 = new Users("nuwan" , 33000L);
        EntityModel<Users> user2Resource = EntityModel.of(user2);
        user2Resource.add(WebMvcLinkBuilder.linkTo(UsersResource.class).slash(user2.getName()).withSelfRel());
        return Arrays.asList(user1Resource,user2Resource);
    }
}
