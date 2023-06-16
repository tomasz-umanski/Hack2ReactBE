package com.example.workflow.user;

import com.example.workflow.user.dto.CreateUserDto;
import com.example.workflow.user.dto.UserDto;
import com.example.workflow.user.dao.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UserMapper {
    UserDto toDto(User user);
    User toEntity(CreateUserDto createUserDto);
}
