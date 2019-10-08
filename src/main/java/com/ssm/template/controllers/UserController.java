package com.ssm.template.controllers;

import com.ssm.template.pojos.User;
import com.ssm.template.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("userLogin.do")
    public ModelAndView getUser(String name, String pass, HttpServletRequest req){
        ModelAndView view = new ModelAndView();
        User user = userService.getUser(name, pass);
        if (user == null){
            view.setViewName("login.jsp");
            view.addObject("tage", "1");
        }else{
            req.getSession().setAttribute("user", user);
            view.setViewName("items.do");
        }
        return view;
    }

    @RequestMapping("userRegist.do")
    public ModelAndView addUser(User user){
        ModelAndView view = new ModelAndView();
        if(userService.addUser(user)){
            view.setViewName("redirect: login.jsp");
        }else{
            view.setViewName("regist.jsp");
            view.addObject("tage", "1");
        }
        return view;
    }

}
