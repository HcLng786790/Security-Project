package com.huuduc.springsecurity.service.impl;

import com.huuduc.springsecurity.model.dto.AuthenDTORequest;
import com.huuduc.springsecurity.model.dto.AuthenDTOResponse;
import com.huuduc.springsecurity.service.AuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenServiceImpl implements AuthenService {

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public AuthenDTOResponse login(AuthenDTORequest authenDTORequest) {
//
//        Authentication authentication=this.authenticationManager
//                .authenticate(
//                        new UsernamePasswordAuthenticationToken(authenDTORequest.getUsername(),authenDTORequest.getPassword())
//                );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        AuthenDTOResponse authenDTOResponse = new AuthenDTOResponse("Đăng nhập thành công");
//
//        return authenDTOResponse;
//    }

}
