package com.huuduc.springsecurity.controller;

import com.huuduc.springsecurity.model.dto.AuthenDTORequest;
import com.huuduc.springsecurity.service.AuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenService authenService;

//    @PostMapping("/login")
//    private ResponseEntity<?> login(@RequestBody(required = false) AuthenDTORequest authenDTORequest){
//
//        return ResponseEntity.ok(this.authenService.login(authenDTORequest));
//
//    }
}
