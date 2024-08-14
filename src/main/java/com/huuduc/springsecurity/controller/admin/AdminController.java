package com.huuduc.springsecurity.controller.admin;

import com.huuduc.springsecurity.model.dto.UserRequest;
import com.huuduc.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUser(){

        return ResponseEntity.ok(this.userService.getAll());
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUserById(@PathVariable Long userId,
                                            @RequestBody UserRequest userRequest){
        return ResponseEntity.ok(this.userService.updateById(userId,userRequest));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
