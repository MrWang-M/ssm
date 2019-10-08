package com.ssm.template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class ZanController {

    @RequestMapping("addZan.do")
    public void addZan(String itemId){
        System.out.println(itemId);
    }
}
