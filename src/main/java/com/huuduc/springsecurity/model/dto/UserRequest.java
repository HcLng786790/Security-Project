package com.huuduc.springsecurity.model.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    private String name;
    private String company;
    private String email;
    private String bio;
    private Date birthday;

    private String country;
    private String phone;

    private String website;

    private String twitter;

    private String facebook;

    private String google;

    private String linkedIn;

    private String instagram;

}
