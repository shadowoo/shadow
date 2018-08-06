package com.guava.cache.jpa.controller;

import com.google.common.base.Optional;
import com.guava.cache.jpa.model.User;
import com.guava.cache.jpa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by heshuanglin on 2018/4/25.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/findAllUsers")
    @ResponseBody
    public List<User> findAllUsers(){
        return userService.findAll();
    }


    @RequestMapping("/findUserByName")
    @ResponseBody
    public User findUserByName(String name) throws ExecutionException {
        return userService.findByName(name);
    }


    @RequestMapping("/findById")
    @ResponseBody
    public User findById(int id){
        Optional<User> optional = userService.findById(id);
        System.out.println(optional);
        if(optional.isPresent()){
            return optional.get();
        }else {
            return optional.orNull();
        }

    }
}
