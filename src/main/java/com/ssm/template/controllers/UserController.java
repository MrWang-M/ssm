package com.ssm.template.controllers;

import com.ssm.template.pojos.User;
import com.ssm.template.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("userLogin.do")
    public void getUser(String name, String pass){
        System.out.println(userService.getUser(name, pass));
    }

    @RequestMapping("userRegist.do")
    public void addUser(User user){
        System.out.println(userService.addUser(user));
    }
}
