package com.build.application.todoList.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class AuthenticationService {


    private Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    public boolean authenticateUser(String username, String password){
        logger.debug(">> authenticateUser");
        boolean isValid = false;
        if(username.equalsIgnoreCase("rajneesh") && password.equalsIgnoreCase("pass")){
            isValid = true;
        }
        logger.debug(">> isValid: {}", isValid);
        logger.debug("<< authenticateUser");
        return isValid;

    }
    
}
