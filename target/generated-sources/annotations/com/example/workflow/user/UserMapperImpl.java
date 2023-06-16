package com.example.workflow.user;

import com.example.workflow.user.dao.User;
import com.example.workflow.user.dto.CreateUserDto;
import com.example.workflow.user.dto.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-17T00:06:52+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }

    @Override
    public User toEntity(CreateUserDto createUserDto) {
        if ( createUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setLogin( createUserDto.getLogin() );

        return user;
    }
}
