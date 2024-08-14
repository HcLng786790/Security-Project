package com.huuduc.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContentController {

    @GetMapping("/")
    public String handleHome(){
        return "home";
    }
    @GetMapping("/home")
    public String handleWelcome(){
        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome(){
        return "home_admin";
    }

    @GetMapping("/user/home")
    public String handleUserHome(){
        return "user_home";
    }

    @GetMapping("/login")
    public String handleLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String handleRegister(){
        return "register";
    }

//    @GetMapping("/admin/update/user/{id}")
//    public String editStudentForm(@PathVariable Long id, Model model) {
//        model.addAttribute("userId", id);
//        return "update_user";
//    }
    @GetMapping("/admin/update/user/{id}")
    public String editStudentForm(@PathVariable Long id){
        return "update_user";
    }
}
