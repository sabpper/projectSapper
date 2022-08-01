package com.demo.controller;

import com.demo.bean.Pet;
import com.demo.mapper.UserMapper;
import com.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Autowired
    Pet pet;

    @Autowired
    UserMapper userMapper;

    @Autowired
    userService useerService;

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "Hello World! This is my SpringBoot!"+ name;
    }

    @RequestMapping("/cat")
    public Pet cat() {
        return pet;
    }

    @RequestMapping("/selectUser")
    public int selectUser() {
        int userList = useerService.count();
//        userList.forEach(System.out::println);
        return userList;
    }
}
