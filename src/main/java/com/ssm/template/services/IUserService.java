package com.ssm.template.services;

import com.ssm.template.pojos.User;

public interface IUserService {
    User getUser(String name, String pass);
    boolean addUser(User user);
}
