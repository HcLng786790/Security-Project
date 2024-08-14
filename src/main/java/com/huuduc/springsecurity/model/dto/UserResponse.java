package com.huuduc.springsecurity.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String name;

    private String username;

    private String email;

    private String company;

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
