package com.ssm.template.controllers;

import com.ssm.template.pojos.User;
import com.ssm.template.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user/")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("userLogin.do")
    public String getUser(String name, String pass, HttpServletRequest req){
        User user = userService.getUser(name, pass);
        if (user == null){
            req.setAttribute("tige","账号或密码错误！");
        }else{

        }
        return "aaaa";
    }

    @RequestMapping("userRegist.do")
    public void addUser(User user){
        System.out.println(userService.addUser(user));
    }
}
