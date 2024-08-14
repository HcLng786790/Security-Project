package com.huuduc.springsecurity.service.impl;

import com.huuduc.springsecurity.exception.NotFoundException;
import com.huuduc.springsecurity.model.data.User;
import com.huuduc.springsecurity.model.dto.UserRequest;
import com.huuduc.springsecurity.model.dto.UserResponse;
import com.huuduc.springsecurity.model.mapper.UserMapper;
import com.huuduc.springsecurity.repository.RoleRepository;
import com.huuduc.springsecurity.repository.UserRepository;
import com.huuduc.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserResponse register(UserRequest userRequest) {

        // TODO: 6/28/2024 check null request
        User newUser = this.userMapper.toEntity(userRequest);
        newUser.setPassword(this.passwordEncoder.encode(userRequest.getPassword()));
        newUser.setRoles(this.roleRepository.findByName("USER"));
        this.userRepository.save(newUser);

        return this.userMapper.toDTO(newUser);
    }

    @Override
    public UserResponse getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = this.userRepository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException(username)
        );

        UserResponse userResponse = this.userMapper.toDTO(user);

        return userResponse;
    }

    @Override
    public List<UserResponse> getAll() {
//        List<User> userList = this.userRepository.findAll();
        List<User> userList = this.userRepository.findUsers("USER");


        List<UserResponse> userResponses = userList.stream()
                .map(u -> this.userMapper.toDTO(u)).toList();

        return userResponses;
    }

    @Override
    public UserResponse updateById(Long userId,UserRequest userRequest) {

        User findUser = this.userRepository.findById(userId).orElseThrow(
                ()-> new NotFoundException(Collections.singletonMap("User id",userId))
        );

        findUser.setUsername(userRequest.getUsername());
        findUser.setName(userRequest.getName());
        findUser.setCompany(userRequest.getCompany());
        findUser.setEmail(userRequest.getEmail());

        this.userRepository.save(findUser);
        return this.userMapper.toDTO(findUser);
    }

    @Override
    public UserResponse getUserById(Long userId) {

        User user = this.userRepository.findById(userId).orElseThrow(
                ()-> new NotFoundException(Collections.singletonMap("User id",userId))
        );

        UserResponse userResponse = this.userMapper.toDTO(user);

        return userResponse;
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = this.userRepository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException(username)
        );

//        user = this.userMapper.toEntity(userRequest);
//        user.setEmail();
        user.setUsername(userRequest.getUsername());
        user.setBio(userRequest.getBio());
        user.setName(userRequest.getName());
        user.setCountry(userRequest.getCountry());
        user.setBirthday(userRequest.getBirthday());
        user.setGoogle(userRequest.getGoogle());
        user.setCompany(userRequest.getCompany());
        user.setFacebook(userRequest.getFacebook());
        user.setInstagram(userRequest.getInstagram());
        user.setTwitter(userRequest.getTwitter());
        user.setEmail(userRequest.getEmail());
        user.setLinkedIn(userRequest.getLinkedIn());
        user.setPhone(userRequest.getPhone());
        user.setWebsite(userRequest.getWebsite());

        this.userRepository.save(user);
        return this.userMapper.toDTO(user);
    }
}
