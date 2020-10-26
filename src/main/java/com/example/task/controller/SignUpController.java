package com.example.task.controller;

import com.example.task.entity.TodoItem;
import com.example.task.pojo.UserBean;
import com.example.task.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @PostMapping(value="/signup")
    public TodoItem signup(@RequestBody UserBean userBean) {
        signUpService.addUser(userBean);
        return null;
    }
}
