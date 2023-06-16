package com.example.workflow.user;

import com.example.workflow.user.dto.CreateUserDto;
import com.example.workflow.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
class UserController {
    private final UserService userService;

    @GetMapping
    public Page<UserDto> findAll(UserSpecification userSpecification, Pageable pageable) {
        return userService.findAll(userSpecification, pageable);
    }

    @PostMapping
    public UserDto create(@RequestBody CreateUserDto createUserDto) {
        return userService.create(createUserDto);
    }
}
