package com.ssm.template.controllers;

import com.ssm.template.handlers.ZanHandler;
import com.ssm.template.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/")
@Controller
public class ZanController {

    @Autowired
    private ZanHandler zanHandler;

    @RequestMapping("addZan.do")
    public void addZan(String itemId, HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("user");
        zanHandler.addZan(user.getId(), itemId);
    }

    @RequestMapping("renameZan.do")
    public void renameZan(String itemId, HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("user");
        zanHandler.renameZan(user.getId(), itemId);
    }
}
