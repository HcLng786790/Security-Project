package com.huuduc.springsecurity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenDTORequest {

    private String username;
    private String password;
}
