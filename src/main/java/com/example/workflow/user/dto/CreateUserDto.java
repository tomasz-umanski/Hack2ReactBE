package com.example.workflow.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

    @NotBlank(message = "login cannot be blank")
    private String login;

    @NotBlank(message = "organizationId cannot be blank")
    private String organizationId;

}
