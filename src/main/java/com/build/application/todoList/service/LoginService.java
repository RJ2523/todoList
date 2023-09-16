package com.build.application.todoList.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class LoginService {
    public void verifyLogin(String password, ModelMap model){
        model.put("password", password);
        System.out.println("login verified");
    }
}
