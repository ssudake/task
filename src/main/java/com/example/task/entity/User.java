package com.example.task.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String profileURL;
    @Column(name = "email")
    private String emailAddress;
    //private int licenseId;
}
