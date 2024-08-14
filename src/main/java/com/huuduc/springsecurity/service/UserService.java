package com.huuduc.springsecurity.service;

import com.huuduc.springsecurity.model.data.User;
import com.huuduc.springsecurity.model.dto.UserRequest;
import com.huuduc.springsecurity.model.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserResponse register(UserRequest userRequest);

    UserResponse getProfile();

    List<UserResponse> getAll();

    UserResponse updateById(Long userId,UserRequest userRequest);

    UserResponse getUserById(Long userId);

    UserResponse updateUser(UserRequest userRequest);
}
