package com.example.task.service;

import com.example.task.assembler.UserAssembler;
import com.example.task.entity.User;
import com.example.task.pojo.UserBean;
import com.example.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SignUpService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAssembler userAssembler;


    public User addUser(UserBean userBean) {
        userAssembler.toDomainObject(userBean);
        return userRepository.save(userAssembler.toDomainObject(userBean));
    }
}
