package com.huuduc.springsecurity.controller;

import com.huuduc.springsecurity.model.dto.UserRequest;
import com.huuduc.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody User user){
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        if(user.getRole()==null){
//            user.setRole("USER");
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(this.userRepository.save(user));
//    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.register(userRequest));
    }
}
