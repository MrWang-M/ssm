package com.ssm.template.services.impl;


import com.ssm.template.dao.UserDAO;
import com.ssm.template.pojos.User;
import com.ssm.template.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserDAO userDAO;

    public User getUser(String name, String pass){
        return userDAO.getUser(name, pass);
    }

    public boolean addUser(User user){
        boolean b = false;
        try{
            b = userDAO.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return b;
    }
}
