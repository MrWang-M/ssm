package com.ssm.template.controllers;

import com.ssm.template.handlers.ZanHandler;
import com.ssm.template.pojos.Item;
import com.ssm.template.pojos.User;
import com.ssm.template.services.impl.ItemService;
import com.ssm.template.vo.ItemVO;
import com.ssm.template.vo.JsonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/")
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("items.do")
    public ModelAndView getItems(HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("user");
        List<ItemVO> list = itemService.getItems(user.getId());
        ModelAndView view = new ModelAndView("index.jsp");
        view.addObject("items", list);
        return view;
    }



    @RequestMapping("text.do")
    @ResponseBody
    public JsonVO text(){
        JsonVO vo = new JsonVO("1", "123");
        return vo;
    }
}
