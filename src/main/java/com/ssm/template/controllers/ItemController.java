package com.ssm.template.controllers;

import com.ssm.template.handlers.ZanHandler;
import com.ssm.template.pojos.Item;
import com.ssm.template.services.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/")
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;



    @RequestMapping("items.do")
    public ModelAndView getItems(){
        List<Item> list = itemService.getItems();
        ModelAndView view = new ModelAndView("index.jsp");
        view.addObject("items", list);
        return view;
    }
}
