package com.huuduc.springsecurity.model.mapper;

import com.huuduc.springsecurity.model.data.User;
import com.huuduc.springsecurity.model.dto.UserRequest;
import com.huuduc.springsecurity.model.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequest userRequest);

    UserResponse toDTO(User user);
}
