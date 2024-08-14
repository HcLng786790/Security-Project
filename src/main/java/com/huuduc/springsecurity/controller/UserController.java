package com.huuduc.springsecurity.controller;

import com.huuduc.springsecurity.model.data.User;
import com.huuduc.springsecurity.model.dto.UserRequest;
import com.huuduc.springsecurity.repository.UserRepository;
import com.huuduc.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(){

        return ResponseEntity.ok(this.userService.getProfile());
    }

//    @GetMapping("/all")
//    public ResponseEntity<?> getAllUser(){
//
//        return ResponseEntity.ok(this.userService.getAll());
//    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(this.userService.updateUser(userRequest));
    }
}
