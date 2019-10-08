package com.ssm.template.services;


import com.ssm.template.dao.UserDAO;
import com.ssm.template.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public User getUser(String name, String pass){
        return userDAO.getUser(name, pass);
    }
}
