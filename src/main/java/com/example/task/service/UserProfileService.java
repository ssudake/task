package com.example.task.service;

import com.example.task.entity.User;
import com.example.task.pojo.UserBean;
import com.example.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    @Autowired
    UserRepository userRepository;

    public User addUser(UserBean userBean) {
        User user = new User();
        user.setId(userBean.getId());
        user.setFirstName(userBean.getFirstName());
        user.setLastName(userBean.getLastName());
        System.out.println(" setting...");
        return userRepository.save(user);
    }
}
