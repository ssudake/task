package com.example.task.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBean {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String profileURL;
    private String emailAddress;
    private long licenseId;
    //private LicenseBean license;
}
