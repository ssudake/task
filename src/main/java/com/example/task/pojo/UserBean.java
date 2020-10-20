package com.example.task.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String profileURL;
    private String emailAddress;
    private LicenseBean license;

}
