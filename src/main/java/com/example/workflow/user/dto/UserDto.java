package com.example.workflow.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "id cannot be blank")
    private String id;

    @NotBlank(message = "login cannot be blank")
    private String login;

    @NotBlank(message = "organizationId cannot be blank")
    private String organizationId;

}
