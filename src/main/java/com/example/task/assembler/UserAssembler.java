package com.example.task.assembler;

import com.example.task.entity.User;
import com.example.task.pojo.UserBean;

public class UserAssembler {

    public UserBean fromDomainObject(User user){
        UserBean userBean = new UserBean();
        userBean.setFirstName(user.getFirstName());
        userBean.setLastName(user.getLastName());
        userBean.setEmailAddress(user.getEmailAddress());
        userBean.setPassword(user.getPassword());
        userBean.setProfileURL(user.getProfileURL());
       // userBean.setLicenseId(user.getLicense().getId());
        return userBean;
    }

    public User toDomainObject(UserBean userBean){
        User user = new User();
        user.setFirstName(userBean.getFirstName());
        user.setLastName(userBean.getLastName());
        user.setEmailAddress(userBean.getEmailAddress());
        user.setPassword(userBean.getPassword());
        user.setProfileURL(userBean.getProfileURL());
        //user.getLicense().setId(userBean.getLicenseId());
        return user;
    }
}
