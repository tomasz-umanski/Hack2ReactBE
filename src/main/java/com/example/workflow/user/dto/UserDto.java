package com.example.workflow.user.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {

    @NotBlank(message = "id cannot be blank")
    private String id;

    @NotBlank(message = "login cannot be blank")
    private String login;

}
