package com.ssm.template.controllers;

import com.ssm.template.handlers.ZanHandler;
import com.ssm.template.pojos.User;
import com.ssm.template.vo.JsonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/")
@Controller
public class ZanController {

    @Autowired
    private ZanHandler zanHandler;

    @RequestMapping("addZan.do")
    @ResponseBody
    public JsonVO addZan(String itemId, HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("user");
        zanHandler.addZan(user.getId(), itemId);
        return new JsonVO("1","点赞成功");
    }

    @RequestMapping("renameZan.do")
    @ResponseBody
    public JsonVO renameZan(String itemId, HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("user");
        zanHandler.renameZan(user.getId(), itemId);
        return new JsonVO("1","取消完成");
    }
}
