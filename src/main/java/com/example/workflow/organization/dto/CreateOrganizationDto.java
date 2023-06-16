package com.example.workflow.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrganizationDto {

    @NotBlank(message = "login cannot be blank")
    private String login;

    @NotBlank(message = "organizationId cannot be blank")
    private String organizationId;

}
